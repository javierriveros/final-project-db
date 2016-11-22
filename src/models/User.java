package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 *
 * @author javier
 */
public class User {
  private int id;
  private String username;
  private String password;
  private String role;
  
  public User(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
  
  
  
  @Override
  public String toString() {
    return String.format("{id: %d, username: %s, password: %s, role: %s}", this.id, this.username, this.password, this.role);
  }
  
  /**
   * Return all users at DB
   * @return users
   * @throws java.sql.SQLException
   */
  public static LinkedList<User> all() throws SQLException {
    LinkedList<User> users = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM users ORDER BY id");
      while (rs.next())
        users.add(getUserFromResultSet(rs));
    }

    return users;
  }
  
  /**
   * Find a user by the ID
   * @param id
   * @return 
   */
  public static User find(int id) {
    return findBy("id", String.valueOf(id));
  }
  
  /**
   * Find a user by the username and password
   * @param username
   * @param password
   * @return 
   */
  public static User find(String username, String password) {
    User user = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM users WHERE username='%s' AND password='%s';", username, password));
        while (rs.next())
          user = getUserFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, sql);
    }
    return user;
  }
  
  /**
   * Find a users by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static User findBy(String field, String value) {
    User users = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM users WHERE %s='%s' LIMIT 1", field, value));
        while (rs.next())
          users = getUserFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, sql);
    }
    return users;
  }
  
  /**
   * Save the current user
   * @return <code>true</code> if could be saved or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO users (username, password, role) VALUES ('%s', '%s', '%s')", this.username,this.password, this.role))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.println("Hubo un error por " + e.getMessage());
        return false;
      }
    }
  }
  
  /**
   * Destroy the current users
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM users WHERE id='%d'", this.id))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  private static User getUserFromResultSet(ResultSet rs) {
    try {
      User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("role"));
      user.setId(rs.getInt("id"));
      return user;
    } catch(SQLException ex) {
      return null;
    }
  }
}

package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 * Inverstigation Group Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Group {
  private int id;
  private String name;
  private int componentsNumber;

  public Group(int id, String name, int componentsNumber) {
    this.id = id;
    this.name = name;
    this.componentsNumber = componentsNumber;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getComponentsNumber() {
    return componentsNumber;
  }

  public void setComponentsNumber(int componentsNumber) {
    this.componentsNumber = componentsNumber;
  }
  
  @Override
  public String toString() {
    return String.format("<%d: %d> %s", this.id, this.componentsNumber, this.name);
  }
  
  /**
   * Return all themes at DB
   * @return themes
   * @throws java.sql.SQLException
   */
  public static LinkedList<Group> all() throws SQLException {
    LinkedList<Group> groups = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM groups");
      while (rs.next())
        groups.add(getGroupFromResultSet(rs));
    }

    return groups;
  }
  
  /**
   * Find a theme by the order Number
   * @param id
   * @return 
   */
  public static Group find(int id) {
    return findBy("id", String.valueOf(id));
  }
  
  /**
   * Find a theme by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Group findBy(String field, String value) {
    Group group = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM groups WHERE %s='%s'", field, value));
        while (rs.next())
          group = getGroupFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return group;
  }
  
  /**
   * Save the current group
   * @return <code>true</code> if could be saved or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO groups (name, components_number) VALUES ('%s', '%d')", this.name, this.componentsNumber))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  /**
   * Destroy the current group
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM groups WHERE id='%d'", this.id))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  /**
   * Return a new group with the DB values
   * @param rs
   * @return 
   */
  private static Group getGroupFromResultSet(ResultSet rs) {
    try {
      return new Group(rs.getInt("id"), rs.getString("name"), rs.getInt("components_number"));
    } catch(SQLException ex) {
      return null;
    }
  }
}

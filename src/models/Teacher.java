package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 * Teacher Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Teacher {
  private long id;
  private String name;
  private String lastName;
  private String address;
  
  public Teacher() {}
  
  public Teacher(long ci, String name, String lastName, String address) {
    this.id = ci;
    this.name = name;
    this.address = address;
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if(name == null || name.length() <= 0)
      throw new NullPointerException("Name can't be empty or null");
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    if(lastName == null || lastName.length() <= 0)
      throw new NullPointerException("Last Name can't be empty or null");
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
  @Override
  public String toString() {
    return String.format("{ci: %d, name: %s, last_name: %s, address: %s}", this.id, this.name, this.lastName, this.address);
  }
  
  /**
   * Return all students at DB
   * @return students
   * @throws java.sql.SQLException
   */
  public static LinkedList<Teacher> all() throws SQLException {
    LinkedList<Teacher> teachers = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM teachers");
      while (rs.next())
        teachers.add(getTeacherFromResultSet(rs));
    }

    return teachers;
  }
  
  /**
   * Find a teacher by the CI
   * @param ci
   * @return 
   */
  public static Teacher find(long ci) {
    Teacher teacher = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM teachers WHERE ci=%d", ci));
        while (rs.next())
          teacher = getTeacherFromResultSet(rs);
      }
    } catch(SQLException sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return teacher;
  }
  
  /**
   * Find a student by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Teacher findBy(String field, String value) {
    Teacher teacher = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM teachers WHERE %s='%s'", value, field));
        while (rs.next())
          teacher = getTeacherFromResultSet(rs);
      }
    } catch(SQLException sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return teacher;
  }
  
  /**
   * Save the current teacher
   * @return <code>true</code> if could be saved or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO teachers (ci, name, address) VALUES ('%d','%s','%s')", this.id, this.name, this.address))) {
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
   * Save the update teacher
   * @return <code>true</code> if could be updated or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean update() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("UPDATE teachers SET name='%s', last_name='%s', address='%s' WHERE id=%d;", this.name, this.lastName, this.address, this.id))) {
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
   * Destroy the current teacher
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM teachers WHERE ci='%d'", this.id))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      } finally {
        con.getCon().close();
      }
    }
  }
  
  private static Teacher getTeacherFromResultSet(ResultSet rs) {
    try {
      return new Teacher(rs.getInt("ci"), rs.getString("name"), rs.getString("last_name"), rs.getString("address"));
    } catch(SQLException ex) {
      //To change
      System.out.println(ex.getMessage());
      return null;
    }
  }
}

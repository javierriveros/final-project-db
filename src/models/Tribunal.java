package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 * Tribunal Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Tribunal {
  private int id;
  private String testPlace;
  private int componentsNumber;
  private int titularTeacherId;
  private Teacher titularTeacher;

  public Tribunal(int id, String testPlace, int componentsNumber, int titularTeacherId) {
    this.id = id;
    this.testPlace = testPlace;
    this.componentsNumber = componentsNumber;
    this.titularTeacherId = titularTeacherId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTestPlace() {
    return testPlace;
  }

  public void setTestPlace(String testPlace) {
    this.testPlace = testPlace;
  }

  public int getComponentsNumber() {
    return componentsNumber;
  }

  public void setComponentsNumber(int componentsNumber) {
    this.componentsNumber = componentsNumber;
  }

  public int getTitularTeacherId() {
    return titularTeacherId;
  }

  public void setTitularTeacherId(int titularTeacherId) {
    this.titularTeacherId = titularTeacherId;
  }

  public Teacher getTitularTeacher() {
    return titularTeacher;
  }

  public void setTitularTeacher(Teacher titularTeacher) {
    this.titularTeacher = titularTeacher;
  }
  
  @Override
  public String toString() {
    return String.format("{id: %d, components_number: %d, test_place: %s, titular_teacher_id: %d}", this.id, this.componentsNumber, this.testPlace, this.titularTeacherId);
  }
  
  /**
   * Return all tribunals at DB
   * @return tribunals
   * @throws java.sql.SQLException
   */
  public static LinkedList<Tribunal> all() throws SQLException {
    LinkedList<Tribunal> tribunals = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM tribunals");
      while (rs.next())
        tribunals.add(getTribunalFromResultSet(rs));
    }

    return tribunals;
  }
  
  /**
   * Find a tribunal by the order Number
   * @param id
   * @return 
   */
  public static Tribunal find(int id) {
    return findBy("id", String.valueOf(id));
  }
  
  /**
   * Find a tribunal by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Tribunal findBy(String field, String value) {
    Tribunal tribunal = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM tribunals WHERE %s='%s'", field, value));
        while (rs.next())
          tribunal = getTribunalFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return tribunal;
  }
  
  /**
   * Save the current tribunal
   * @return <code>true</code> if could be saved or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO tribunals (test_place, components_number, teacher_id) VALUES ('%s', '%d', '%d')", this.testPlace, this.componentsNumber, this.titularTeacherId))) {
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
   * Update the current tribunal
   * @return <code>true</code> if could be updated or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean update() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("UPDATE tribunals SET test_place='%s', components_number=%d, teacher_id=%d WHERE id=%d", this.testPlace, this.componentsNumber, this.titularTeacherId, this.id))) {
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
   * Destroy the current tribunal
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM tribunals WHERE id='%d'", this.id))) {
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
   * Return a new tribunal with the DB values
   * @param rs
   * @return 
   */
  public static Tribunal getTribunalFromResultSet(ResultSet rs) {
    try {
      Tribunal tribunal = new Tribunal(rs.getInt("id"), rs.getString("test_place"), rs.getInt("components_number"), rs.getInt("teacher_id"));
      tribunal.setTitularTeacher(Teacher.find(rs.getInt("teacher_id")));
      return tribunal;
    } catch(SQLException ex) {
      return null;
    }
  }
}

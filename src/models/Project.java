package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 * Project Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Project {
  private int orderNumber;
  private Timestamp startDate;
  private int tribunalId;

  /**
   * Project constructor
   * @param orderNumber
   * @param startDate
   * @param tribunalId 
   */
  public Project(int orderNumber, Timestamp startDate, int tribunalId) {
    this.orderNumber = orderNumber;
    this.startDate = startDate;
    this.tribunalId = tribunalId;
  }
  
  public int getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    if (orderNumber > 0) 
      throw new NumberFormatException("Order Number must be greater than zero");
    this.orderNumber = orderNumber;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    if(startDate == null) 
      throw new NullPointerException("Start Date can't be emtpy");
    this.startDate = startDate;
  }

  public int getTribunalId() {
    return tribunalId;
  }

  public void setTribunalId(int tribunalId) {
    this.tribunalId = tribunalId;
  }
  
  @Override
  public String toString() {
    return String.format("{order_numer: %d, start_date: %s}", this.orderNumber, this.startDate);
  }
  
  /**
   * Return all projects at DB
   * @return projects
   * @throws java.sql.SQLException
   */
  public static LinkedList<Project> all() throws SQLException {
    LinkedList<Project> projects = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM projects");
      while (rs.next())
        projects.add(getProjectFromResultSet(rs));
    }

    return projects;
  }
  
  /**
   * Find a project by the Order Number
   * @param orderNumber
   * @return 
   */
  public static Project find(int orderNumber) {
    return findBy("order_number", String.valueOf(orderNumber));
  }
  
  /**
   * Find a project by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Project findBy(String field, String value) {
    Project project = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM projects WHERE %s='%s'", field, value));
        while (rs.next())
          project = getProjectFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return project;
  }
  
  /**
   * Save the current project
   * @return <code>true</code> if could be saved or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO projects (order_number, start_date, tribunal_id) VALUES ('%d', '%s', '%d)", this.orderNumber, this.startDate, this.tribunalId))) {
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
   * Destroy the current project
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM projects WHERE order_number='%d'", this.orderNumber))) {
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
   * Return a new project with the DB values
   * @param rs
   * @return 
   */
  private static Project getProjectFromResultSet(ResultSet rs) {
    try {
      return new Project(rs.getInt("order_number"), rs.getTimestamp("start_date"), rs.getInt("tribunal_id"));
    } catch(SQLException ex) {
      return null;
    }
  }
}

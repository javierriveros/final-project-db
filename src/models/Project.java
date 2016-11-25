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
  private Timestamp endDate;
  private int tribunalId;
  private Student student;
  private Theme theme;
  private String duration;
  
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
    this.theme = null;
    this.student = null;
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
  
  public Theme getTheme() {
    return this.theme;
  }
  
  public Student getStudent() {
    return this.student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public void setTheme(Theme theme) {
    this.theme = theme;
  }

  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getDuration() {
    return duration;
  }
  
  @Override
  public String toString() {
    return String.format("{order_numer: %d, start_date: %s, end_date: %s, duration: %s}", this.orderNumber, this.startDate, this.endDate, this.duration);
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
      ResultSet rs = sm.executeQuery("select *, age(p.end_date, p.start_date) from projects p left join themes t on t.order_number=p.order_number left join students s on p.order_number=s.order_number;");
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
    return findBy("p.order_number", String.valueOf(orderNumber));
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
        ResultSet rs = sm.executeQuery(String.format("select *, age(p.end_date, p.start_date) from projects p left join themes t on t.order_number=p.order_number left join students s on p.order_number=s.order_number WHERE %s='%s'", field, value));
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
   * Save the update project
   * @return <code>true</code> if could be updated or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean update() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("UPDATE projects SET start_date='%s', tribunal_id=%d WHERE order_number=%d;", this.startDate, this.tribunalId, this.orderNumber))) {
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
      Project p =  new Project(rs.getInt("order_number"), rs.getTimestamp("start_date"), rs.getInt("tribunal_id"));
      p.setTheme(new Theme(rs.getInt("order_number"), rs.getString("title")));
      p.setStudent(new Student(rs.getInt("registration_number"), rs.getString("name"), rs.getString("last_name"), rs.getTimestamp("incorporation_date")));
      p.setDuration(rs.getString("age"));
      return p;
    } catch(SQLException ex) {
      return null;
    }
  }
  
  /**
   * Return a new project with the DB values and attributes
   * @param rs
   * @return 
   */
  private static Project getProjectFromResultSetWithAttributes(ResultSet rs) {
    try {
      Project p =  new Project(rs.getInt("order_number"), rs.getTimestamp("start_date"), rs.getInt("tribunal_id"));
      p.setTheme(new Theme(rs.getInt("order_number"), rs.getString("title")));
      p.setStudent(new Student(rs.getInt("registration_number"), rs.getString("name"), rs.getString("last_name"), rs.getTimestamp("incorporation_date")));
      p.setDuration(rs.getString("age"));
      return p;
    } catch(SQLException ex) {
      return null;
    }
  }
}

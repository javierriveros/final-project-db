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
  private int studentRegistrationNumber;
  private Student student;
  private Theme theme;
  private Tribunal tribunal;
  private String duration;
  private String status;
  
  /**
   * Project constructor
   * @param orderNumber
   * @param startDate
   * @param tribunalId 
   * @param studentRegistrationNumber 
   */
  public Project(int orderNumber, Timestamp startDate, Timestamp endDate, int tribunalId, int studentRegistrationNumber, Theme theme) {
    this.orderNumber = orderNumber;
    this.startDate = startDate;
    this.endDate = endDate;
    this.tribunalId = tribunalId;
    this.studentRegistrationNumber = studentRegistrationNumber;
    this.theme = theme;
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
    if (duration == null) {
      return "En curso";
    } else if(duration.isEmpty()) {
      return "En curso";
    }
    return duration;
  }

  public int getStudentRegistrationNumber() {
    return studentRegistrationNumber;
  }

  public void setStudentRegistrationNumber(int studentRegistrationNumber) {
    this.studentRegistrationNumber = studentRegistrationNumber;
  }

  public Tribunal getTribunal() {
    return tribunal;
  }

  public void setTribunal(Tribunal tribunal) {
    this.tribunal = tribunal;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
  @Override
  public String toString() {
    return String.format("{order_numer: %d, start_date: %s, end_date: %s, duration: %s, status: %s, tribunal_id: %d, student_rn: %d}", this.orderNumber, this.startDate, this.endDate, this.duration, this.status, this.tribunalId, this.studentRegistrationNumber);
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
      ResultSet rs = sm.executeQuery("select *, age(end_date, start_date) from projects order by order_number;");
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
        ResultSet rs = sm.executeQuery(String.format("select *, age(end_date, start_date) from projects WHERE %s='%s'", field, value));
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
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO projects (start_date, tribunal_id, student_registration_number) VALUES ('%s', '%d', '%d')", this.startDate, this.tribunalId, this.studentRegistrationNumber))) {
      try {
        ps.execute();
        this.theme.setOrderNumber(Project.all().getLast().getOrderNumber());
      this.theme.save();
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
    try {
      String sql = "UPDATE projects SET start_date='"+this.startDate+"', end_date='"+this.endDate+"', status='"+this.status+"',tribunal_id="+this.tribunalId+" WHERE order_number="+this.orderNumber+"";
      PreparedStatement ps = con.getCon().prepareStatement(sql);
      ps.execute();
      return true;
    } catch(SQLException e) {
      System.out.printf("Hubo un error por %s", e.getMessage());
      return false;
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
      Project p =  new Project(rs.getInt("order_number"), rs.getTimestamp("start_date"), rs.getTimestamp("end_date"), rs.getInt("tribunal_id"), rs.getInt("student_registration_number"), Theme.find(rs.getInt("order_number")));
      p.setStudent(Student.find(rs.getInt("student_registration_number")));
      p.setDuration(rs.getString("age"));
      p.setStatus(rs.getString("status"));
      p.setTribunal(Tribunal.find(rs.getInt("tribunal_id")));
      return p;
    } catch(SQLException ex) {
      return null;
    }
  }
}

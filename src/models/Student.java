package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 * Student Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Student {
  private int registrationNumber;
  private String name;
  private String lastName;
  private Timestamp incorporationDate;
  private int ci;
  //Foreign keys
  private int orderNumber;
  private int groupId;
  private int teacherId;

  private Student() {}
  
  public Student(int ci, String name, String lastName, Timestamp incorporationDate) {
    this.setCi(ci);
    this.setName(name);
    this.setLastName(lastName);
    this.setIncorporationDate(incorporationDate);
  }

  public int getCi() {
    return ci;
  }

  public void setCi(int ci) {
    this.ci = ci;
  }

  public void setRegistrationNumber(int registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Timestamp getIncorporationDate() {
    return incorporationDate;
  }

  public void setIncorporationDate(Timestamp incorporationDate) {
    this.incorporationDate = incorporationDate;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
  }

  public int getGroupId() {
    return groupId;
  }

  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }

  public int getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(int teacherId) {
    this.teacherId = teacherId;
  }

  public int getRegistrationNumber() {
    return registrationNumber;
  }
  
  @Override
  public String toString() {
    return String.format("{registration_number: %d, ci: %d, incorporation_date: %s, name: %s, last_name: %s, teacher_id: %d, group_id: %d, order_number: %d}", this.registrationNumber, this.ci, this.incorporationDate, this.name, this.lastName, this.teacherId, this.groupId, this.orderNumber);
  }
  
  /**
   * Return all students at DB
   * @return students
   * @throws java.sql.SQLException
   */
  public static LinkedList<Student> all() throws SQLException {
    LinkedList<Student> students = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM students ORDER BY registration_number");
      while (rs.next())
        students.add(getStudentFromResultSet(rs));
    }

    return students;
  }
  
  /**
   * Return all students at DB
   * @return students
   * @throws java.sql.SQLException
   */
  public LinkedList<Teacher> getTeachersWhoHelpMe() throws SQLException {
    LinkedList<Teacher> teachers = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery(String.format("SELECT * FROM helps h JOIN teachers t ON h.teacher_id=t.id WHERE h.student_registration_number=%d", this.registrationNumber));
      while (rs.next())
        teachers.add(Teacher.getTeacherFromResultSet(rs));
    }

    return teachers;
  }
  
  /**
   * Find a student by the Registration Number
   * @param registrationNumber
   * @return 
   */
  public static Student find(int registrationNumber) {
    return findBy("registration_number", String.valueOf(registrationNumber));
  }
  
  /**
   * Find a student by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Student findBy(String field, String value) {
    Student student = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM students WHERE %s='%s'", field, value));
        while (rs.next())
          student = getStudentFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return student;
  }
  
  /**
   * Save the current student
   * @return <code>true</code> if could be saved or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try {
      String sql;
      if (this.groupId == 0)
        sql = String.format("INSERT INTO students (ci, name, last_name, incorporation_date) VALUES ('%d', '%s','%s','%s')", this.ci, this.name, this.lastName, this.incorporationDate);
      else
        sql = String.format("INSERT INTO students (ci, name, last_name, incorporation_date, group_id) VALUES ('%d', '%s','%s','%s', '%d')", this.ci, this.name, this.lastName, this.incorporationDate, this.groupId);
      
      PreparedStatement ps = con.getCon().prepareStatement(sql);
      ps.execute();
      return true;
    } catch(SQLException e) {
      System.out.println("Hubo un error por " + e.getMessage());
      return false;
    }
  }
  
  /**
   * Update the current student
   * @return <code>true</code> if could be saved or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean update() throws SQLException {
    Connection con = Connection.getInstance();
    String sql = "UPDATE students SET ci='"+this.ci+"', name='"+this.name+"', last_name='"+this.lastName+"', incorporation_date='"+this.incorporationDate+"', teacher_id="+(this.teacherId == 0 ? null : this.teacherId)+", group_id="+(this.groupId == 0 ? null : this.groupId)+", order_number="+(this.orderNumber == 0 ? null : this.orderNumber)+" WHERE registration_number="+this.registrationNumber;
    try {
      PreparedStatement ps = con.getCon().prepareStatement(sql);
      ps.execute();
      return true;
    } catch(SQLException e) {
      System.out.println("Hubo un error por " + e.getMessage());
      return false;
    }
  }
  
  /**
   * Destroy the current student
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM students WHERE registration_number='%d'", this.registrationNumber))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  public static Student getStudentFromResultSet(ResultSet rs) {
    try {
      Student student = new Student(rs.getInt("ci"), rs.getString("name"), rs.getString("last_name"), rs.getTimestamp("incorporation_date"));
      student.setRegistrationNumber(rs.getInt("registration_number"));
      student.setGroupId(rs.getInt("group_id"));
      student.setOrderNumber(rs.getInt("order_number"));
      student.setTeacherId(rs.getInt("teacher_id"));
      return student;
    } catch(SQLException ex) {
      return null;
    }
  }
  
  /**
   * Return the actual time in Timestamp format
   * @return now
   */
  public static Timestamp now() {
    return Timestamp.from(Instant.now());
  }
}

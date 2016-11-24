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
  private int teacherCi;

  private Student() {}
  
  public Student(int registrationNumber, String name, String lastName, Timestamp incorporationDate) {
    this.setRegistrationNumber(registrationNumber);
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

  public int getTeacherCi() {
    return teacherCi;
  }

  public void setTeacherCi(int teacherCi) {
    this.teacherCi = teacherCi;
  }

  public int getRegistrationNumber() {
    return registrationNumber;
  }
  
  @Override
  public String toString() {
    return String.format("{registration_number: %d, ci: %d, incorporation_date: %s, name: %s, last_name: %s}", this.registrationNumber, this.ci, this.incorporationDate, this.name, this.lastName);
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
      ResultSet rs = sm.executeQuery("SELECT * FROM students ORDER BY ci");
      while (rs.next())
        students.add(getStudentFromResultSet(rs));
    }

    return students;
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
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO students (registration_number, name, last_name, incorporation_date) VALUES ('%d', '%s','%s','%s')", this.registrationNumber, this.name, this.lastName, this.incorporationDate))) {
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
   * Update the current student
   * @return <code>true</code> if could be saved or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean update() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("UPDATE students SET ci='%d', name='%s', last_name='%s', incorporation_date='%s' WHERE ci=%d", this.ci, this.name, this.lastName, this.incorporationDate, this.ci))) {
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
  
  private static Student getStudentFromResultSet(ResultSet rs) {
    try {
      Student student = new Student(rs.getInt("registration_number"), rs.getString("name"), rs.getString("last_name"), rs.getTimestamp("incorporation_date"));
      student.setCi(rs.getInt("ci"));
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

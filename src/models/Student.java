package models;

import com.sun.media.jfxmedia.logging.Logger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;
import views.Index;

/**
 * Student Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Student {
  private int registrationNumber;
  private String name;
  private Timestamp incorporationDate;
  private int ci;

  public Student(int registrationNumber, int ci, String name, Timestamp incorporationDate) {
    this.setRegistrationNumber(registrationNumber);
    this.setCi(ci);
    this.setName(name);
    this.setIncorporationDate(incorporationDate);
    System.out.println(incorporationDate);
  }

  private Student() {}

  public int getRegistrationNumber() {
    return registrationNumber;
  }

  public int getCi() {
    return ci;
  }

  public void setCi(int ci) {
    this.ci = ci;
  }

  public void setRegistrationNumber(int registrationNumber) {
    if(registrationNumber < 0) 
      throw new NumberFormatException("Registration Number must be greater than zero");
    this.registrationNumber = registrationNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if(name == null || name.length() <= 0)
      throw new NullPointerException("Name can't be empty or null");
    this.name = name;
  }

  public Timestamp getIncorporationDate() {
    return incorporationDate;
  }

  public void setIncorporationDate(Timestamp incorporationDate) {
    if(incorporationDate == null) 
      throw new NullPointerException("Incorporation Date can't be emtpy");
    this.incorporationDate = incorporationDate;
  }
  
  @Override
  public String toString() {
    return String.format("<%d - %d - %s> %s", this.registrationNumber, this.ci, this.incorporationDate, this.name);
  }
  
  /**
   * Return all students at DB
   * @return students
   */
  public static LinkedList<Student> all() {
    LinkedList<Student> students = new LinkedList<>();
    students.add(new Student());
    return students;
  }
  
  /**
   * Find a student by the Registrastion Number
   * @param registrationNumber
   * @return 
   */
  public static Student find(int registrationNumber) {
    return findBy("registration_number", registrationNumber);
  }
  
  /**
   * Find a student by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Student findBy(String field, int value) {
    Student student = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery("SELECT * FROM students WHERE "+field+"='"+value+"'");
        while (rs.next())
          student = new Student(rs.getInt("registration_number"), rs.getInt("ci"), rs.getString("name"), rs.getTimestamp("incorporation_date"));
      }
      con.getCon().close();
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return student;
  }
  
  /**
   * Save the current student
   * @return <code>true</code> if could be saved or <code>false</code> if else
   */
  public boolean save() {
    return false;
  }
  
  /**
   * Destroy the current student
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   */
  public boolean destroy() {
    return false;
  }
}

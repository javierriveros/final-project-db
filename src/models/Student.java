package models;

import java.util.Calendar;
import java.sql.Date;
import java.util.LinkedList;

/**
 * Student Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Student {
  private int registrationNumber;
  private String name;
  private Date incorporationDate;

  public Student(int registrationNumber, String name, Date incorporationDate) {
    this.setRegistrationNumber(registrationNumber);
    this.setName(name);
    this.setIncorporationDate(incorporationDate);
    System.out.println(incorporationDate);
  }

  private Student() {}

  public int getRegistrationNumber() {
    return registrationNumber;
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

  public Date getIncorporationDate() {
    return incorporationDate;
  }

  public void setIncorporationDate(Date incorporationDate) {
    if(incorporationDate == null) 
      throw new NullPointerException("Incorporation Date can't be emtpy");
    this.incorporationDate = incorporationDate;
  }
  
  @Override
  public String toString() {
    return String.format("<%d - %s> %s", this.registrationNumber, this.incorporationDate, this.name);
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
    return new Student();
  }
  
  /**
   * Find a student by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Student findBy(String field, int value) {
    return new Student();
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
  
  public static void main(String[] args) {
    
  }
}

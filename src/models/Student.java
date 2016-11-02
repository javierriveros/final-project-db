package models;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Student Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Student {
  private int registrationNumber;
  private String name;
  private GregorianCalendar incorporationDate;

  public Student(int registrationNumber, String name, GregorianCalendar incorporationDate) {
    this.setRegistrationNumber(registrationNumber);
    this.setName(name);
    this.setIncorporationDate(incorporationDate);
  }

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

  public GregorianCalendar getIncorporationDate() {
    return incorporationDate;
  }

  public void setIncorporationDate(GregorianCalendar incorporationDate) {
    if(incorporationDate == null) 
      throw new NullPointerException("Incorporation Date can't be emtpy");
    this.incorporationDate = incorporationDate;
  }
  
  private String getTime() {
    if (incorporationDate == null) return "";
    String am_pm[] = {"AM", "PM"};
    
    return String.format(
      "%d/%d/%d %d:%d:%d %s",
      incorporationDate.get(Calendar.YEAR),
      incorporationDate.get(Calendar.MONTH),
      incorporationDate.get(Calendar.DAY_OF_MONTH),
      incorporationDate.get(Calendar.HOUR_OF_DAY),
      incorporationDate.get(Calendar.MINUTE),
      incorporationDate.get(Calendar.SECOND),
      am_pm[incorporationDate.get(Calendar.AM_PM)]
    );
  }

  @Override
  public String toString() {
    return String.format("<%d - %s> %s", this.registrationNumber, this.getTime(), this.name);
  }
  
  public static void main(String[] args) {
    GregorianCalendar date = new GregorianCalendar(2016, 11, 2, 13, 44, 00);
    Student student =new Student(2, "Javier", date);
    System.out.println(student);
  }
}

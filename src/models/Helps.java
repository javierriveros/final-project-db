/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 *
 * @author javier
 */
public class Helps {
  private int studentRegistrationNumber;
  private int teacherId;

  public Helps(int studentRegistrationNumber, int teacherId) {
    this.studentRegistrationNumber = studentRegistrationNumber;
    this.teacherId = teacherId;
  }

  public int getStudentRegistrationNumber() {
    return studentRegistrationNumber;
  }

  public void setStudentRegistrationNumber(int studentRegistrationNumber) {
    this.studentRegistrationNumber = studentRegistrationNumber;
  }

  public int getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(int teacherId) {
    this.teacherId = teacherId;
  }
  
  @Override
  public String toString() {
    return String.format("{student_registration_number: %d, teacher_id: %d}", this.studentRegistrationNumber, this.teacherId);
  }
  
  public static LinkedList<Helps> all() throws SQLException {
    LinkedList<Helps> helps = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM helps");
      while (rs.next())
        helps.add(getHelpsFromResultSet(rs));
    }

    return helps;
  }
  
  public static Helps find(int studentRN, int teacherId) {
    Helps helps = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM helps WHERE student_registration_number='%d' AND teacher_id='%d'", studentRN, teacherId));
        while (rs.next())
          helps = getHelpsFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Helps.class.getName()).log(Level.SEVERE, null, sql);
    }
    return helps;
  }
  
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO helps (student_registration_number, teacher_id) VALUES ('%d', '%d')", this.studentRegistrationNumber, this.teacherId))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.println("Hubo un error por " + e.getMessage());
        return false;
      }
    }
  }

  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM helps WHERE student_registration_number='%d' AND teacher_id", this.studentRegistrationNumber, this.teacherId))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  private static Helps getHelpsFromResultSet(ResultSet rs) {
    try {
      return new Helps(rs.getInt("student_registration_number"), rs.getInt("teacher_id"));
    } catch(SQLException ex) {
      return null;
    }
  }
}

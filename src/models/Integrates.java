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
public class Integrates {
  private int teacherId;
  private int tribunalId;
  
  public Integrates(int teacherId, int tribunalId) {
    this.teacherId = teacherId;
    this.tribunalId = tribunalId;
  }

  public int getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(int teacherId) {
    this.teacherId = teacherId;
  }

  public int getTribunalId() {
    return tribunalId;
  }

  public void setTribunalId(int tribunalId) {
    this.tribunalId = tribunalId;
  }
  
  @Override
  public String toString() {
    return String.format("{tribunal_id: %d, teacher_id: %d}", this.tribunalId, this.teacherId);
  }
  
  public static LinkedList<Integrates> all() throws SQLException {
    LinkedList<Integrates> integrates = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM integrates");
      while (rs.next())
        integrates.add(getIntegratesFromResultSet(rs));
    }

    return integrates;
  }
  
  public static Integrates find(int tribunalId, int teacherId) {
    Integrates integrates = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM integrates WHERE tribunal_id='%d' AND teacher_id='%d'", tribunalId, teacherId));
        while (rs.next())
          integrates = getIntegratesFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Integrates.class.getName()).log(Level.SEVERE, null, sql);
    }
    return integrates;
  }
  
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO integrates (teacher_id, tribunal_id) VALUES ('%d', '%d')", this.teacherId, this.tribunalId))) {
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
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM integrates WHERE tribunal_id='%d' AND teacher_id='%d'", this.tribunalId, this.teacherId))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  private static Integrates getIntegratesFromResultSet(ResultSet rs) {
    try {
      return new Integrates(rs.getInt("teacher_id"), rs.getInt("tribunal_id"));
    } catch(SQLException ex) {
      System.out.printf("Error por: %s", ex.getMessage());
      return null;
    }
  }
}

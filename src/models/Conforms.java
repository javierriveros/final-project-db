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
public class Conforms {
  private int teacherId;
  private int groupId;
  private Teacher teacher;
  private Group group;

  public Conforms(int teacherId, int groupId) {
    this.teacherId = teacherId;
    this.groupId = groupId;
  }

  public int getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(int teacherId) {
    this.teacherId = teacherId;
  }

  public int getGroupId() {
    return groupId;
  }

  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }
  
  @Override
  public String toString() {
    return String.format("{teacher_id: %d, group_id: %d}", this.teacherId, this.groupId);
  }

  public static LinkedList<Conforms> all() throws SQLException {
    LinkedList<Conforms> conforms = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("select g.id as group_id, g.name as group_name, g.description as group_description, g.components_number as group_components_number, t.id as teacher_id, t.name as teacher_name, t.last_name as teacher_last_name, t.address as teacher_address from conforms c join teachers t on c.teacher_id=t.id join groups g on g.id=c.group_id;");
      while (rs.next())
        conforms.add(getConformsFromResultSet(rs));
    }

    return conforms;
  }

  public static Conforms findBy(int teacherId, int groupId) {
    Conforms conforms = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT g.id AS group_id, g.name AS group_name, g.description AS group_description, g.components_number AS group_components_number, t.id AS teacher_id, t.name AS teacher_name, t.last_name AS teacher_last_name, t.address AS teacher_address FROM conforms c JOIN teachers t ON c.teacher_id=t.id JOIN groups g ON g.id=c.group_id WHERE teacher_id='%s' AND group_id", teacherId, groupId));
        while (rs.next())
          conforms = getConformsFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Conforms.class.getName()).log(Level.SEVERE, null, sql);
    }
    return conforms;
  }
  
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO conforms (teacher_id, group_id) VALUES ('%d', '%d')", this.teacherId, this.groupId))) {
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
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM conforms WHERE teacher_id='%d' AND group_id='%d'", this.teacherId, this.groupId))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  private static Conforms getConformsFromResultSet(ResultSet rs) {
    try {
      Conforms conforms = new Conforms(rs.getInt("teacher_id"), rs.getInt("group_id"));
      conforms.setGroup(new Group(rs.getInt("group_id"), rs.getString("group_name"), rs.getString("group_description"), rs.getInt("group_components_number")));
      conforms.setTeacher(new Teacher(rs.getLong("teacher_id"), rs.getString("teacher_name"), rs.getString("teacher_last_name"), rs.getString("teacher_address")));
      return conforms;
    } catch(SQLException ex) {
      return null;
    }
  }
}

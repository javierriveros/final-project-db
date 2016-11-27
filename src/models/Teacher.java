package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 * Teacher Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Teacher {
  private long id;
  private String name;
  private String lastName;
  private String address;
  
  public Teacher() {}
  
  public Teacher(long id, String name, String lastName, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getFullName() {
    return String.format("%s %s", this.name, this.lastName);
  }

  public LinkedList<Tribunal> getTribunalsWhereIAmTitular() throws SQLException {
    LinkedList<Tribunal> tribunals = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery(String.format("SELECT * FROM tribunals WHERE teacher_id=%d;", this.id));
      while (rs.next())
        tribunals.add(Tribunal.getTribunalFromResultSet(rs));
    }

    return tribunals;
  }
  
  public LinkedList<Tribunal> getTribunalsWhereIAmMember() throws SQLException {
    LinkedList<Tribunal> tribunals = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery(String.format("select t.id,t.test_place,t.components_number,t.teacher_id from integrates i join tribunals t on t.id=i.tribunal_id where i.teacher_id=%d", this.id));
      while (rs.next())
        tribunals.add(Tribunal.getTribunalFromResultSet(rs));
    }

    return tribunals;
  }
  
  public LinkedList<Group> getGroupsWhereIAmTitular() throws SQLException {
    LinkedList<Group> groups = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery(String.format("SELECT * FROM groups WHERE teacher_id=%d;", this.id));
      while (rs.next())
        groups.add(Group.getGroupFromResultSet(rs));
    }

    return groups;
  }
  
  public LinkedList<Group> getGroupsWhereIAmMember() throws SQLException {
    LinkedList<Group> groups = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery(String.format("SELECT g.id,g.name,g.components_number,g.description,g.teacher_id FROM conforms c join groups g on c.group_id=g.id WHERE c.teacher_id=%d", this.id));
      while (rs.next())
        groups.add(Group.getGroupFromResultSet(rs));
    }

    return groups;
  }
  
  public LinkedList<Student> getStudentsITeach() throws SQLException {
    LinkedList<Student> students = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery(String.format("SELECT * FROM students WHERE teacher_id=%d", this.id));
      while (rs.next())
        students.add(Student.getStudentFromResultSet(rs));
    }

    return students;
  }
  
  public LinkedList<Student> getStudentsIHelp() throws SQLException {
    LinkedList<Student> students = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery(String.format("SELECT * FROM helps h join students s on h.student_registration_number=s.registration_number WHERE h.teacher_id=%d", this.id));
      while (rs.next())
        students.add(Student.getStudentFromResultSet(rs));
    }

    return students;
  }
  
  @Override
  public String toString() {
    return String.format("{id: %d, name: %s, last_name: %s, address: %s}", this.id, this.name, this.lastName, this.address);
  }
  
  /**
   * Return all students at DB
   * @return students
   * @throws java.sql.SQLException
   */
  public static LinkedList<Teacher> all() throws SQLException {
    LinkedList<Teacher> teachers = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM teachers");
      while (rs.next())
        teachers.add(getTeacherFromResultSet(rs));
    }

    return teachers;
  }
  
  /**
   * Find a teacher by the CI
   * @param ci
   * @return 
   */
  public static Teacher find(long ci) {
    Teacher teacher = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM teachers WHERE id=%d", ci));
        while (rs.next())
          teacher = getTeacherFromResultSet(rs);
      }
    } catch(SQLException sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return teacher;
  }
  
  /**
   * Find a student by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Teacher findBy(String field, String value) {
    Teacher teacher = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM teachers WHERE %s='%s'", field, value));
        while (rs.next())
          teacher = getTeacherFromResultSet(rs);
      }
    } catch(SQLException sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return teacher;
  }
  
  /**
   * Save the current teacher
   * @return <code>true</code> if could be saved or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO teachers (id, name, last_name, address) VALUES ('%d','%s', '%s','%s')", this.id, this.name, this.lastName, this.address))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por: %s", e.getMessage());
        return false;
      }
    }
  }
  
  /**
   * Save the update teacher
   * @return <code>true</code> if could be updated or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean update() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("UPDATE teachers SET name='%s', last_name='%s', address='%s' WHERE id=%d;", this.name, this.lastName, this.address, this.id))) {
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
   * Destroy the current teacher
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM teachers WHERE id=%d", this.id))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  public static Teacher getTeacherFromResultSet(ResultSet rs) {
    try {
      return new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("last_name"), rs.getString("address"));
    } catch(SQLException ex) {
      //To change
      System.out.println(ex.getMessage());
      return null;
    }
  }
}

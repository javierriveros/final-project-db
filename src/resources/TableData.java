/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Group;
import models.Project;
import models.Student;
import models.Teacher;
import models.Tribunal;

/**
 *
 * @author javier
 */
public class TableData {
  public static void loadStudents(JTable studentsTable) throws SQLException {
    DefaultTableModel studentsModel = (DefaultTableModel) studentsTable.getModel();
    Util.clearTable(studentsModel);
    LinkedList<Student> students = Student.all();
    students.forEach(student -> {
      studentsModel.addRow(new Object[] {
        student.getRegistrationNumber(),
        student.getCi(),
        student.getName(),
        student.getLastName(),
        student.getIncorporationDate()
      });
    });
  }
  
  public static void loadTeachers(JTable teachersTable) throws SQLException {
    DefaultTableModel teachersModel = (DefaultTableModel) teachersTable.getModel();
    Util.clearTable(teachersModel);
    LinkedList<Teacher> teachers = Teacher.all();
    teachers.forEach(teacher -> {
      teachersModel.addRow(new Object[] {
        teacher.getId(),
        teacher.getName(),
        teacher.getLastName(),
        teacher.getAddress()
      });
    });
  }
  
  public static void loadGroups(JTable groupsTable) throws SQLException {
    DefaultTableModel groupsModel = (DefaultTableModel) groupsTable.getModel();
    Util.clearTable(groupsModel);
    LinkedList<Group> groups = Group.all();
    groups.forEach(group -> {
      groupsModel.addRow(new Object[] {
        group.getId(),
        group.getName(),
        group.getComponentsNumber()
      });
    });
  }
  
  public static void loadProjects(JTable projectsTable) throws SQLException {
    DefaultTableModel projectsModel = (DefaultTableModel) projectsTable.getModel();
    Util.clearTable(projectsModel);
    LinkedList<Project> projects = Project.all();
    projects.forEach(project -> {
      projectsModel.addRow(new Object[] {
        project.getOrderNumber(),
        project.getTheme().getTitle(),
        project.getStartDate(),
        project.getTribunalId()
      });
    });
  }
  
  public static void loadTribunals(JTable tribunalsTable) throws SQLException {
    DefaultTableModel tribunalsModel = (DefaultTableModel) tribunalsTable.getModel();
    Util.clearTable(tribunalsModel);
    LinkedList<Tribunal> tribunals = Tribunal.all();
    tribunals.forEach(tribunal -> {
      tribunalsModel.addRow(new Object[] {
        tribunal.getId(),
        tribunal.getTestPlace(),
        tribunal.getComponentsNumber()
      });
    });
  }
}

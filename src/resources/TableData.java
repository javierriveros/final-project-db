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
import models.Helps;
import models.Project;
import models.Student;
import models.Teacher;
import models.Tribunal;

/**
 *
 * @author javier
 */
public class TableData {
  public static void loadStudents(JTable studentsTable, LinkedList<Student> students) throws SQLException {
    DefaultTableModel studentsModel = (DefaultTableModel) studentsTable.getModel();
    Util.clearTable(studentsModel);
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
  
  public static void loadTeachers(JTable teachersTable, LinkedList<Teacher> teachers) throws SQLException {
    DefaultTableModel teachersModel = (DefaultTableModel) teachersTable.getModel();
    Util.clearTable(teachersModel);
    teachers.forEach(teacher -> {
      teachersModel.addRow(new Object[] {
        teacher.getId(),
        teacher.getName(),
        teacher.getLastName(),
        teacher.getAddress()
      });
    });
  }
  
  public static void loadGroups(JTable groupsTable, LinkedList<Group> groups) throws SQLException {
    DefaultTableModel groupsModel = (DefaultTableModel) groupsTable.getModel();
    Util.clearTable(groupsModel);
    groups.forEach(group -> {
      groupsModel.addRow(new Object[] {
        group.getId(),
        group.getName(),
        group.getComponentsNumber(),
        group.getTitularTeacher().getId(),
        group.getTitularTeacher().getFullName()
      });
    });
  }
  
  public static void loadProjects(JTable projectsTable, LinkedList<Project> projects) throws SQLException {
    DefaultTableModel projectsModel = (DefaultTableModel) projectsTable.getModel();
    Util.clearTable(projectsModel);
    projects.forEach(project -> {
      projectsModel.addRow(new Object[] {
        project.getOrderNumber(),
        project.getTheme().getTitle(),
        project.getStartDate(),
        project.getEndDate(),
        project.getDuration(),
        project.getStatus()
      });
    });
  }
  
  public static void loadTribunals(JTable tribunalsTable, LinkedList<Tribunal> tribunals) throws SQLException {
    DefaultTableModel tribunalsModel = (DefaultTableModel) tribunalsTable.getModel();
    Util.clearTable(tribunalsModel);
    tribunals.forEach(tribunal -> {
      tribunalsModel.addRow(new Object[] {
        tribunal.getId(),
        tribunal.getTestPlace(),
        tribunal.getComponentsNumber(),
        tribunal.getTitularTeacher().getId(),
        tribunal.getTitularTeacher().getFullName()
      });
    });
  }
  
  public static void loadHelps(JTable helpsTable, LinkedList<Helps> helps) throws SQLException {
    DefaultTableModel helpsModel = (DefaultTableModel) helpsTable.getModel();
    Util.clearTable(helpsModel);
    helps.forEach(help -> {
      helpsModel.addRow(new Object[] {
        help.getTeacherId(),
        help.getStudentRegistrationNumber()
      });
    });
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.students;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;  
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import models.*;

/**
 *
 * @author javier
 */
public class Index extends javax.swing.JFrame {

  /**
   * Creates new form Index
   */
  public Index() {
    initComponents();
    try {
      addStudents();
    } catch (SQLException ex) {
      Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  private void addStudents() throws SQLException {
    setLocationRelativeTo(null);
    loadStudents();
    loadTeachers();
    loadGroups();
    loadProjects();
    loadTribunals();
    loadThemes();
  }
  
  private void loadStudents() throws SQLException {
    DefaultTableModel studentsModel = (DefaultTableModel) studentsTable.getModel();
    clearTable(studentsModel);
    LinkedList<Student> students = Student.all();
    students.forEach(student -> {
      studentsModel.addRow(new Object[] {
        student.getCi(),
        student.getRegistrationNumber(),
        student.getName(),
        student.getLastName()
      });
    });
  }
  
  private void loadTeachers() throws SQLException {
    DefaultTableModel teachersModel =  (DefaultTableModel) teachersTable.getModel();
    LinkedList<Teacher> teachers = Teacher.all();
    teachers.forEach(teacher -> {
      teachersModel.addRow(new Object[] {
        teacher.getCi(),
        teacher.getName(),
        teacher.getLastName()
      });
    });
  }
  
  private void loadGroups() throws SQLException {
    DefaultTableModel groupsModel =  (DefaultTableModel) groupsTable.getModel();
    LinkedList<Group> groups = Group.all();
    groups.forEach(group -> {
      groupsModel.addRow(new Object[] {
        group.getId(),
        group.getName(),
        group.getComponentsNumber()
      });
    });
  }
  
  private void loadProjects() throws SQLException {
    DefaultTableModel projectsModel =  (DefaultTableModel) projectsTable.getModel();
    LinkedList<Project> projects = Project.all();
    projects.forEach(project -> {
      projectsModel.addRow(new Object[] {
        project.getOrderNumber(),
        project.getStartDate(),
        project.getTribunalId()
      });
    });
  }
  
  private void loadTribunals() throws SQLException {
    DefaultTableModel tribunalsModel =  (DefaultTableModel) tribunalsTable.getModel();
    LinkedList<Tribunal> tribunals = Tribunal.all();
    tribunals.forEach(tribunal -> {
      tribunalsModel.addRow(new Object[] {
        tribunal.getId(),
        tribunal.getTestPlace(),
        tribunal.getComponentsNumber()
      });
    });
  }
  
  private void loadThemes() throws SQLException {
    DefaultTableModel themesModel =  (DefaultTableModel) themesTable.getModel();
    LinkedList<Theme> themes = Theme.all();
    themes.forEach(theme -> {
      themesModel.addRow(new Object[] {
        theme.getOrderNumber(),
        theme.getTitle()
      });
    });
  }
  
  private void clearTable(DefaultTableModel model) {
    for (int i = 0; i < model.getRowCount(); i++) {
      model.removeRow(i);
      i-=1;
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainNav = new javax.swing.JTabbedPane();
    jScrollPane4 = new javax.swing.JScrollPane();
    projectsTable = new javax.swing.JTable();
    jScrollPane5 = new javax.swing.JScrollPane();
    tribunalsTable = new javax.swing.JTable();
    jScrollPane6 = new javax.swing.JScrollPane();
    themesTable = new javax.swing.JTable();
    jScrollPane1 = new javax.swing.JScrollPane();
    teachersTable = new javax.swing.JTable();
    jScrollPane2 = new javax.swing.JScrollPane();
    groupsTable = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane7 = new javax.swing.JScrollPane();
    studentsTable = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    projectsTable.setBorder(null);
    projectsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Order Number", "Start Date", "Tribunal ID"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane4.setViewportView(projectsTable);

    mainNav.addTab("Projects", jScrollPane4);

    tribunalsTable.setBorder(null);
    tribunalsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Test Place", "Components Number"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane5.setViewportView(tribunalsTable);

    mainNav.addTab("Tribunals", jScrollPane5);

    themesTable.setBorder(null);
    themesTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Order Number", "Title"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane6.setViewportView(themesTable);

    mainNav.addTab("Themes", jScrollPane6);

    teachersTable.setBorder(null);
    teachersTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "CI", "Name", "Last Name"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(teachersTable);

    mainNav.addTab("Teachers", jScrollPane1);

    groupsTable.setBorder(null);
    groupsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Id", "Name", "Components Number"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.String.class, java.lang.Object.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane2.setViewportView(groupsTable);

    mainNav.addTab("Groups", jScrollPane2);

    jPanel1.setLayout(new java.awt.BorderLayout());

    studentsTable.setBorder(null);
    studentsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "CI", "Code", "Name", "Last Name"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane7.setViewportView(studentsTable);

    jPanel1.add(jScrollPane7, java.awt.BorderLayout.CENTER);

    jButton1.setText("Refresh");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jButton1)
        .addContainerGap(918, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jButton1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

    mainNav.addTab("Students", jPanel1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainNav)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainNav, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
      loadStudents();
    }catch(SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * @param args the command line arguments
   * @throws java.text.ParseException
   * @throws java.lang.ClassNotFoundException
   * @throws java.lang.InstantiationException
   * @throws java.lang.IllegalAccessException
   */
  public static void main(String args[]) throws ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    try {
      UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
    } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {}
    java.awt.EventQueue.invokeLater(() -> new Index().setVisible(true));
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable groupsTable;
  private javax.swing.JButton jButton1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JScrollPane jScrollPane6;
  private javax.swing.JScrollPane jScrollPane7;
  private javax.swing.JTabbedPane mainNav;
  private javax.swing.JTable projectsTable;
  private javax.swing.JTable studentsTable;
  private javax.swing.JTable teachersTable;
  private javax.swing.JTable themesTable;
  private javax.swing.JTable tribunalsTable;
  // End of variables declaration//GEN-END:variables
}

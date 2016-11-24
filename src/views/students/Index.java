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
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.*;
import resources.Util;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

/**
 *
 * @author javier
 */
public class Index extends javax.swing.JFrame {
  private TableRowSorter rSorterStudents;
  private TableRowSorter rSorterTribunals;
  private TableRowSorter rSorterThemes;
  private TableRowSorter rSorterTeachers;
  private TableRowSorter rSorterProjects;
  private TableRowSorter rSorterGroups;
          
  /**
   * Creates new form Index
   */
  public Index() {
    initComponents();
    try {
      showData();
    } catch (SQLException ex) {
      Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
    }
    addPlaceholders();
    addRowSorters();
  }
  
  private void addPlaceholders() {
    String text = "Escriba aquí para buscar";
    Util.addPlaceholder(this.searchStudentsField, text);
    Util.addPlaceholder(this.searchGroupsField, text);
    Util.addPlaceholder(this.searchProjectsField, text);
    Util.addPlaceholder(this.searchTeachersField, text);
    Util.addPlaceholder(this.searchTribunalsField, text);
    Util.addPlaceholder(this.searchThemesField, text);
    Util.addPlaceholder(this.searchGroupsField, text);
  }
  
  private void addRowSorters() {
    rSorterStudents = new TableRowSorter(studentsTable.getModel());
    studentsTable.setRowSorter(rSorterStudents);
    
    rSorterTeachers = new TableRowSorter(teachersTable.getModel());
    teachersTable.setRowSorter(rSorterTeachers);
    
    rSorterGroups = new TableRowSorter(groupsTable.getModel());
    groupsTable.setRowSorter(rSorterGroups);
    
    rSorterProjects = new TableRowSorter(projectsTable.getModel());
    projectsTable.setRowSorter(rSorterProjects);
    
    rSorterTribunals = new TableRowSorter(tribunalsTable.getModel());
    tribunalsTable.setRowSorter(rSorterTribunals);
    
    rSorterThemes = new TableRowSorter(themesTable.getModel());
    themesTable.setRowSorter(rSorterThemes);
  }
  
  private void showData() throws SQLException {
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
    DefaultTableModel teachersModel = (DefaultTableModel) teachersTable.getModel();
    clearTable(teachersModel);
    LinkedList<Teacher> teachers = Teacher.all();
    teachers.forEach(teacher -> {
      teachersModel.addRow(new Object[] {
        teacher.getId(),
        teacher.getName(),
        teacher.getLastName()
      });
    });
  }
  
  private void loadGroups() throws SQLException {
    DefaultTableModel groupsModel = (DefaultTableModel) groupsTable.getModel();
    clearTable(groupsModel);
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
    DefaultTableModel projectsModel = (DefaultTableModel) projectsTable.getModel();
    clearTable(projectsModel);
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
    DefaultTableModel tribunalsModel = (DefaultTableModel) tribunalsTable.getModel();
    clearTable(tribunalsModel);
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
    DefaultTableModel themesModel = (DefaultTableModel) themesTable.getModel();
    clearTable(themesModel);
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
    jPanel1 = new javax.swing.JPanel();
    jScrollPane7 = new javax.swing.JScrollPane();
    studentsTable = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    refreshStudents = new javax.swing.JButton();
    searchStudentsBy = new javax.swing.JComboBox<>();
    searchStudentsField = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    jPanel8 = new javax.swing.JPanel();
    refreshTribunals = new javax.swing.JButton();
    searchTribunalsBy = new javax.swing.JComboBox<>();
    searchTribunalsField = new javax.swing.JTextField();
    jScrollPane5 = new javax.swing.JScrollPane();
    tribunalsTable = new javax.swing.JTable();
    jPanel4 = new javax.swing.JPanel();
    jPanel9 = new javax.swing.JPanel();
    refreshThemes = new javax.swing.JButton();
    searchThemesBy = new javax.swing.JComboBox<>();
    searchThemesField = new javax.swing.JTextField();
    jScrollPane6 = new javax.swing.JScrollPane();
    themesTable = new javax.swing.JTable();
    jPanel5 = new javax.swing.JPanel();
    jPanel10 = new javax.swing.JPanel();
    refreshTeachers = new javax.swing.JButton();
    searchTeachersBy = new javax.swing.JComboBox<>();
    searchTeachersField = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    teachersTable = new javax.swing.JTable();
    jPanel6 = new javax.swing.JPanel();
    jPanel11 = new javax.swing.JPanel();
    refreshGroups = new javax.swing.JButton();
    searchGroupsBy = new javax.swing.JComboBox<>();
    searchGroupsField = new javax.swing.JTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    groupsTable = new javax.swing.JTable();
    jPanel7 = new javax.swing.JPanel();
    jPanel12 = new javax.swing.JPanel();
    refreshProjects = new javax.swing.JButton();
    searchProjectsBy = new javax.swing.JComboBox<>();
    searchProjectsField = new javax.swing.JTextField();
    jScrollPane4 = new javax.swing.JScrollPane();
    projectsTable = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

    refreshStudents.setText("Refresh");
    refreshStudents.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        refreshStudentsActionPerformed(evt);
      }
    });

    searchStudentsBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por", "CI", "Código", "Nombres", "Apellidos" }));

    searchStudentsField.setForeground(new java.awt.Color(204, 204, 204));
    searchStudentsField.setText("Escriba aquí para buscar");
    searchStudentsField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        searchStudentsFieldKeyPressed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(searchStudentsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(searchStudentsField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
        .addComponent(refreshStudents)
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(refreshStudents)
          .addComponent(searchStudentsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(searchStudentsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

    mainNav.addTab("Students", jPanel1);

    jPanel3.setLayout(new java.awt.BorderLayout());

    refreshTribunals.setText("Refresh");
    refreshTribunals.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        refreshTribunalsActionPerformed(evt);
      }
    });

    searchTribunalsBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por", "ID", "Lugar de presentación" }));

    searchTribunalsField.setForeground(new java.awt.Color(204, 204, 204));
    searchTribunalsField.setText("Escriba aquí para buscar");
    searchTribunalsField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        searchTribunalsFieldKeyTyped(evt);
      }
    });

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(searchTribunalsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(searchTribunalsField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
        .addComponent(refreshTribunals)
        .addContainerGap())
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(searchTribunalsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(searchTribunalsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(refreshTribunals))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel3.add(jPanel8, java.awt.BorderLayout.PAGE_START);

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

    jPanel3.add(jScrollPane5, java.awt.BorderLayout.CENTER);

    mainNav.addTab("Tribunals", jPanel3);

    jPanel4.setLayout(new java.awt.BorderLayout());

    refreshThemes.setText("Refresh");
    refreshThemes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        refreshThemesActionPerformed(evt);
      }
    });

    searchThemesBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por", "Número de orden", "Título" }));

    searchThemesField.setForeground(new java.awt.Color(204, 204, 204));
    searchThemesField.setText("Escriba aquí para buscar");
    searchThemesField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        searchThemesFieldKeyTyped(evt);
      }
    });

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(searchThemesBy, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(searchThemesField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
        .addComponent(refreshThemes)
        .addContainerGap())
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(searchThemesBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(searchThemesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(refreshThemes))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel4.add(jPanel9, java.awt.BorderLayout.PAGE_START);

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

    jPanel4.add(jScrollPane6, java.awt.BorderLayout.CENTER);

    mainNav.addTab("Themes", jPanel4);

    jPanel5.setLayout(new java.awt.BorderLayout());

    refreshTeachers.setText("Refresh");
    refreshTeachers.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        refreshTeachersActionPerformed(evt);
      }
    });

    searchTeachersBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por", "CI", "Nombres", "Apellidos" }));

    searchTeachersField.setForeground(new java.awt.Color(204, 204, 204));
    searchTeachersField.setText("Escriba aquí para buscar");
    searchTeachersField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        searchTeachersFieldKeyTyped(evt);
      }
    });

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(searchTeachersBy, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(searchTeachersField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
        .addComponent(refreshTeachers)
        .addContainerGap())
    );
    jPanel10Layout.setVerticalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel10Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(searchTeachersBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(searchTeachersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(refreshTeachers))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel5.add(jPanel10, java.awt.BorderLayout.PAGE_START);

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

    jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    mainNav.addTab("Teachers", jPanel5);

    jPanel6.setLayout(new java.awt.BorderLayout());

    refreshGroups.setText("Refresh");
    refreshGroups.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        refreshGroupsActionPerformed(evt);
      }
    });

    searchGroupsBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por", "ID", "Nombre" }));

    searchGroupsField.setForeground(new java.awt.Color(204, 204, 204));
    searchGroupsField.setText("Escriba aquí para buscar");
    searchGroupsField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        searchGroupsFieldKeyTyped(evt);
      }
    });

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(searchGroupsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(searchGroupsField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
        .addComponent(refreshGroups)
        .addContainerGap())
    );
    jPanel11Layout.setVerticalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel11Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(searchGroupsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(searchGroupsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(refreshGroups))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel6.add(jPanel11, java.awt.BorderLayout.PAGE_START);

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

    jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

    mainNav.addTab("Groups", jPanel6);

    jPanel7.setLayout(new java.awt.BorderLayout());

    refreshProjects.setText("Refresh");
    refreshProjects.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        refreshProjectsActionPerformed(evt);
      }
    });

    searchProjectsBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por", "Número de orden", "Fecha de inicio", "Tribunal ID" }));

    searchProjectsField.setForeground(new java.awt.Color(204, 204, 204));
    searchProjectsField.setText("Escriba aquí para buscar");
    searchProjectsField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        searchProjectsFieldKeyTyped(evt);
      }
    });

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
      jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(searchProjectsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(searchProjectsField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
        .addComponent(refreshProjects)
        .addContainerGap())
    );
    jPanel12Layout.setVerticalGroup(
      jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel12Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(searchProjectsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(searchProjectsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(refreshProjects))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel7.add(jPanel12, java.awt.BorderLayout.PAGE_START);

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

    jPanel7.add(jScrollPane4, java.awt.BorderLayout.CENTER);

    mainNav.addTab("Projects", jPanel7);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainNav)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainNav)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void refreshTribunalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTribunalsActionPerformed
    try {
      loadTribunals();
    } catch (SQLException ex) {
      System.out.printf("Error por: %s", ex.getMessage());
    }
  }//GEN-LAST:event_refreshTribunalsActionPerformed

  private void refreshThemesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshThemesActionPerformed
    try {
      loadThemes();
    } catch (SQLException ex) {
      System.out.printf("Error por: %s", ex.getMessage());
    }
  }//GEN-LAST:event_refreshThemesActionPerformed

  private void refreshTeachersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTeachersActionPerformed
    try {
      loadTeachers();
    } catch (SQLException ex) {
      System.out.printf("Error por: %s", ex.getMessage());
    }
  }//GEN-LAST:event_refreshTeachersActionPerformed

  private void refreshGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshGroupsActionPerformed
    try {
      loadGroups();
    } catch (SQLException ex) {
      System.out.printf("Error por: %s", ex.getMessage());
    }
  }//GEN-LAST:event_refreshGroupsActionPerformed

  private void refreshProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshProjectsActionPerformed
    try {
      loadProjects();
    } catch (SQLException ex) {
      System.out.printf("Error por: %s", ex.getMessage());
    }
  }//GEN-LAST:event_refreshProjectsActionPerformed
  
  private void refreshStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshStudentsActionPerformed
    try {
      loadStudents();
    }catch(SQLException ex) {
      System.out.printf("Error por: %s", ex.getMessage());
    }
  }//GEN-LAST:event_refreshStudentsActionPerformed

  private void searchTribunalsFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTribunalsFieldKeyTyped
    if(searchTribunalsBy.getSelectedIndex() == 0) return;
    rSorterTribunals.setRowFilter(RowFilter.regexFilter(searchTribunalsField.getText(), searchTribunalsBy.getSelectedIndex()-1));
  }//GEN-LAST:event_searchTribunalsFieldKeyTyped

  private void searchThemesFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchThemesFieldKeyTyped
    if(searchThemesBy.getSelectedIndex() == 0) return;
    rSorterThemes.setRowFilter(RowFilter.regexFilter(searchThemesField.getText(), searchThemesBy.getSelectedIndex()-1));
  }//GEN-LAST:event_searchThemesFieldKeyTyped

  private void searchTeachersFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTeachersFieldKeyTyped
    if(searchTeachersBy.getSelectedIndex() == 0) return;
    rSorterTeachers.setRowFilter(RowFilter.regexFilter(searchTeachersField.getText(), searchTeachersBy.getSelectedIndex()-1));
  }//GEN-LAST:event_searchTeachersFieldKeyTyped

  private void searchGroupsFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGroupsFieldKeyTyped
    if(searchGroupsBy.getSelectedIndex() == 0) return;
    rSorterGroups.setRowFilter(RowFilter.regexFilter(searchGroupsField.getText(), searchGroupsBy.getSelectedIndex()-1));
  }//GEN-LAST:event_searchGroupsFieldKeyTyped

  private void searchProjectsFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProjectsFieldKeyTyped
    if(searchProjectsBy.getSelectedIndex() == 0) return;
    rSorterProjects.setRowFilter(RowFilter.regexFilter(searchProjectsField.getText(), searchProjectsBy.getSelectedIndex()-1));
  }//GEN-LAST:event_searchProjectsFieldKeyTyped

  private void searchStudentsFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchStudentsFieldKeyPressed
    if(searchStudentsBy.getSelectedIndex() == 0) return;
    rSorterStudents.setRowFilter(RowFilter.regexFilter(searchStudentsField.getText(), searchStudentsBy.getSelectedIndex()-1));
  }//GEN-LAST:event_searchStudentsFieldKeyPressed
  
  /**
   * @param args the command line arguments
   * @throws java.text.ParseException
   * @throws java.lang.ClassNotFoundException
   * @throws java.lang.InstantiationException
   * @throws java.lang.IllegalAccessException
   */
  public static void main(String args[]) throws ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    try {
      UIManager.setLookAndFeel(SyntheticaPlainLookAndFeel.class.getName());
    } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {}
    java.awt.EventQueue.invokeLater(() -> new Index().setVisible(true));
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable groupsTable;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel10;
  private javax.swing.JPanel jPanel11;
  private javax.swing.JPanel jPanel12;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JScrollPane jScrollPane6;
  private javax.swing.JScrollPane jScrollPane7;
  private javax.swing.JTabbedPane mainNav;
  private javax.swing.JTable projectsTable;
  private javax.swing.JButton refreshGroups;
  private javax.swing.JButton refreshProjects;
  private javax.swing.JButton refreshStudents;
  private javax.swing.JButton refreshTeachers;
  private javax.swing.JButton refreshThemes;
  private javax.swing.JButton refreshTribunals;
  private javax.swing.JComboBox<String> searchGroupsBy;
  private javax.swing.JTextField searchGroupsField;
  private javax.swing.JComboBox<String> searchProjectsBy;
  private javax.swing.JTextField searchProjectsField;
  private javax.swing.JComboBox<String> searchStudentsBy;
  private javax.swing.JTextField searchStudentsField;
  private javax.swing.JComboBox<String> searchTeachersBy;
  private javax.swing.JTextField searchTeachersField;
  private javax.swing.JComboBox<String> searchThemesBy;
  private javax.swing.JTextField searchThemesField;
  private javax.swing.JComboBox<String> searchTribunalsBy;
  private javax.swing.JTextField searchTribunalsField;
  private javax.swing.JTable studentsTable;
  private javax.swing.JTable teachersTable;
  private javax.swing.JTable themesTable;
  private javax.swing.JTable tribunalsTable;
  // End of variables declaration//GEN-END:variables
}

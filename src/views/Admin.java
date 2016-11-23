/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.SQLException;
import models.User;
import resources.TableData;
import resources.Util;

/**
 *
 * @author Jhonathan Mejia Leon
 */
public class Admin extends javax.swing.JFrame {
  private User user;
  /**
   * Creates new form Ventana
   * @param user
   */
  public Admin(User user) {
    this.user = user;
    initComponents();
    addAttributes();
    try {
      loadData();
    } catch (SQLException e) {}
  }

  private void addAttributes() {
    setLocationRelativeTo(null);
    setTitle(String.format("Usted se ha identificado como: %s", this.user.getUsername()));
    String text = "Escriba aquí para buscar";
    Util.addPlaceholder(teachersField, text);
    Util.addPlaceholder(studentsField, text);
    Util.addPlaceholder(groupsField, text);
    Util.addPlaceholder(projectsField, text);
    Util.addPlaceholder(tribunalsField, text);
  }
  
  private void loadData() throws SQLException {
    TableData.loadStudents(studentsTable);
    TableData.loadTeachers(teachersTable);
    TableData.loadProjects(projectsTable);
    TableData.loadTribunals(tribunalsTable);
    TableData.loadGroups(groupsTable);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTabbedPane2 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    teachersTable = new javax.swing.JTable();
    Añadir = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    searchTeachersBy = new javax.swing.JComboBox();
    teachersField = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    studentsTable = new javax.swing.JTable();
    searchStudentsBy = new javax.swing.JComboBox();
    studentsField = new javax.swing.JTextField();
    jButton5 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
    jButton7 = new javax.swing.JButton();
    Añadir1 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jPanel4 = new javax.swing.JPanel();
    searchProjectsBy = new javax.swing.JComboBox();
    jButton13 = new javax.swing.JButton();
    projectsField = new javax.swing.JTextField();
    jButton14 = new javax.swing.JButton();
    jButton15 = new javax.swing.JButton();
    Añadir3 = new javax.swing.JButton();
    jButton16 = new javax.swing.JButton();
    jScrollPane4 = new javax.swing.JScrollPane();
    projectsTable = new javax.swing.JTable();
    jPanel5 = new javax.swing.JPanel();
    jButton17 = new javax.swing.JButton();
    tribunalsField = new javax.swing.JTextField();
    jButton18 = new javax.swing.JButton();
    Añadir4 = new javax.swing.JButton();
    searchTribunalsBy = new javax.swing.JComboBox();
    jButton19 = new javax.swing.JButton();
    jButton20 = new javax.swing.JButton();
    jScrollPane5 = new javax.swing.JScrollPane();
    tribunalsTable = new javax.swing.JTable();
    jPanel3 = new javax.swing.JPanel();
    searchGroupsBy = new javax.swing.JComboBox();
    jButton9 = new javax.swing.JButton();
    groupsField = new javax.swing.JTextField();
    jButton10 = new javax.swing.JButton();
    jButton11 = new javax.swing.JButton();
    Añadir2 = new javax.swing.JButton();
    jButton12 = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    groupsTable = new javax.swing.JTable();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem8 = new javax.swing.JMenuItem();
    jMenuItem7 = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenuItem6 = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    teachersTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Id", "Nombres", "Apellidos", "Direccion"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, true, true
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(teachersTable);

    Añadir.setText("Añadir");
    Añadir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        AñadirActionPerformed(evt);
      }
    });

    jButton2.setText("Modificar");

    jButton3.setText("Eliminar");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    searchTeachersBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por:", "Id", "Nombres", "Apellidos", "Direccion" }));

    jButton1.setText("Refresh");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton4.setText("Ver");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(searchTeachersBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(teachersField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Añadir)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton1)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Añadir)
          .addComponent(jButton2)
          .addComponent(jButton3)
          .addComponent(searchTeachersBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(teachersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1)
          .addComponent(jButton4))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Profesores", jPanel1);

    studentsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Numero de Registro", "Codigo", "Nombre", "Apellido", "Fecha de Incorporacion"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, true, true, true
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane2.setViewportView(studentsTable);
    if (studentsTable.getColumnModel().getColumnCount() > 0) {
      studentsTable.getColumnModel().getColumn(4).setHeaderValue("Fecha de Incorporacion");
    }

    searchStudentsBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por:", "Numero de Registro", "Codigo", "Nombre", "Apellido" }));

    jButton5.setText("Refresh");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    jButton6.setText("Ver");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });

    jButton7.setText("Eliminar");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton7ActionPerformed(evt);
      }
    });

    Añadir1.setText("Añadir");
    Añadir1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Añadir1ActionPerformed(evt);
      }
    });

    jButton8.setText("Modificar");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(searchStudentsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(studentsField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Añadir1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton5))
          .addComponent(jScrollPane2))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Añadir1)
          .addComponent(jButton8)
          .addComponent(jButton7)
          .addComponent(studentsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton5)
          .addComponent(jButton6)
          .addComponent(searchStudentsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Estudiantes", jPanel2);

    searchProjectsBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por:", "Numero de Orden", "Tema" }));

    jButton13.setText("Eliminar");
    jButton13.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton13ActionPerformed(evt);
      }
    });

    jButton14.setText("Modificar");

    jButton15.setText("Refresh");
    jButton15.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton15ActionPerformed(evt);
      }
    });

    Añadir3.setText("Añadir");
    Añadir3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Añadir3ActionPerformed(evt);
      }
    });

    jButton16.setText("Ver");
    jButton16.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton16ActionPerformed(evt);
      }
    });

    projectsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Numero de Orden", "Tema", "Fecha de Inicio", "Evaluacion Tribunal"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, true, true
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane4.setViewportView(projectsTable);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane4)
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(searchProjectsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(projectsField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Añadir3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton14)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton13)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton16)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton15)))
        .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Añadir3)
          .addComponent(jButton14)
          .addComponent(jButton13)
          .addComponent(projectsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton15)
          .addComponent(jButton16)
          .addComponent(searchProjectsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Proyectos", jPanel4);

    jButton17.setText("Eliminar");
    jButton17.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton17ActionPerformed(evt);
      }
    });

    jButton18.setText("Modificar");

    Añadir4.setText("Añadir");
    Añadir4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Añadir4ActionPerformed(evt);
      }
    });

    searchTribunalsBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por:", "Id", "Lugar de Presentación" }));

    jButton19.setText("Refresh");
    jButton19.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton19ActionPerformed(evt);
      }
    });

    jButton20.setText("Ver");
    jButton20.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton20ActionPerformed(evt);
      }
    });

    tribunalsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Id", "Lugar de Presentacion", "Numero de Integrantes"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, true
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane5.setViewportView(tribunalsTable);

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(searchTribunalsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tribunalsField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Añadir4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton18)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton17)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton20)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton19))
          .addComponent(jScrollPane5))
        .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Añadir4)
          .addComponent(jButton18)
          .addComponent(jButton17)
          .addComponent(searchTribunalsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tribunalsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton19)
          .addComponent(jButton20))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Tribunal", jPanel5);

    searchGroupsBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por:", "Id", "Nombre" }));

    jButton9.setText("Eliminar");
    jButton9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton9ActionPerformed(evt);
      }
    });

    jButton10.setText("Modificar");

    jButton11.setText("Refresh");
    jButton11.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton11ActionPerformed(evt);
      }
    });

    Añadir2.setText("Añadir");
    Añadir2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Añadir2ActionPerformed(evt);
      }
    });

    jButton12.setText("Ver");
    jButton12.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton12ActionPerformed(evt);
      }
    });

    groupsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Id", "Nombre", "Numero de Integrantes"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, true
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane3.setViewportView(groupsTable);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane3)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(searchGroupsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(groupsField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Añadir2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton10)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton12)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton11)))
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Añadir2)
          .addComponent(jButton10)
          .addComponent(jButton9)
          .addComponent(searchGroupsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(groupsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton11)
          .addComponent(jButton12))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Grupos", jPanel3);

    jMenu1.setText("Archivo");

    jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
    jMenuItem8.setText("Historial de Inicio de Sesion");
    jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem8ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem8);

    jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar_16px.png"))); // NOI18N
    jMenuItem7.setText("Cerrar Sesión");
    jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem7ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem7);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Ver");

    jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
    jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil-ruler-icon.png"))); // NOI18N
    jMenuItem3.setText("Reporte de Proyectos");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem3ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem3);

    jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK));
    jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/igroup_n.png"))); // NOI18N
    jMenuItem4.setText("Reporte de Grupos");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem4);

    jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
    jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
    jMenuItem5.setText("Reporte de Profesores");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem5ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem5);

    jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
    jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Graduate-male-icon.png"))); // NOI18N
    jMenuItem6.setText("Reporte de Estudiantes");
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem6ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem6);

    jMenuBar1.add(jMenu2);

    jMenu3.setText("Ayuda");

    jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
    jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ayuda_16px.png"))); // NOI18N
    jMenuItem1.setText("Índice");
    jMenu3.add(jMenuItem1);

    jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/acercaDe_16px.png"))); // NOI18N
    jMenuItem2.setText("Acerca de");
    jMenu3.add(jMenuItem2);

    jMenuBar1.add(jMenu3);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane2)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void Añadir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Añadir2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Añadir2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void Añadir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Añadir4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Añadir4ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void Añadir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Añadir3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Añadir3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void Añadir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Añadir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Añadir1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AñadirActionPerformed

  private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    dispose();
    new views.users.Login().setVisible(true);
  }//GEN-LAST:event_jMenuItem7ActionPerformed

  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    new views.projects.ReporteProyectos().setVisible(true);
  }//GEN-LAST:event_jMenuItem3ActionPerformed

  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    new views.groups.ReporteGrupo().setVisible(true);
  }//GEN-LAST:event_jMenuItem4ActionPerformed

  private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    new views.teachers.ReporteProfesores().setVisible(true);
  }//GEN-LAST:event_jMenuItem5ActionPerformed

  private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    new views.students.ReporteEstudiantes().setVisible(true);
  }//GEN-LAST:event_jMenuItem6ActionPerformed

  private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
    new views.Historial().setVisible(true);
  }//GEN-LAST:event_jMenuItem8ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {TableData.loadTeachers(teachersTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    try {TableData.loadStudents(studentsTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
    try {TableData.loadProjects(projectsTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton15ActionPerformed

  private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
    try {TableData.loadTribunals(tribunalsTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton19ActionPerformed

  private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    try {TableData.loadGroups(groupsTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton11ActionPerformed

  private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
    try {
      System.out.println(getPK(groupsTable));
    } catch(ArrayIndexOutOfBoundsException e) {}
  }//GEN-LAST:event_jButton12ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try {
      System.out.println(getPK(teachersTable));
    } catch(ArrayIndexOutOfBoundsException e) {}
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    try {
      System.out.println(getPK(studentsTable));
    } catch(ArrayIndexOutOfBoundsException e) {}
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
    try {
      System.out.println(getPK(projectsTable));
    } catch(ArrayIndexOutOfBoundsException e) {}
  }//GEN-LAST:event_jButton16ActionPerformed

  private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
    try {
      System.out.println(getPK(tribunalsTable));
    } catch(ArrayIndexOutOfBoundsException e) {}
  }//GEN-LAST:event_jButton20ActionPerformed

  private int getPK(javax.swing.JTable table) throws ArrayIndexOutOfBoundsException {
    return Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton Añadir;
  private javax.swing.JButton Añadir1;
  private javax.swing.JButton Añadir2;
  private javax.swing.JButton Añadir3;
  private javax.swing.JButton Añadir4;
  private javax.swing.JTextField groupsField;
  private javax.swing.JTable groupsTable;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton10;
  private javax.swing.JButton jButton11;
  private javax.swing.JButton jButton12;
  private javax.swing.JButton jButton13;
  private javax.swing.JButton jButton14;
  private javax.swing.JButton jButton15;
  private javax.swing.JButton jButton16;
  private javax.swing.JButton jButton17;
  private javax.swing.JButton jButton18;
  private javax.swing.JButton jButton19;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton20;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton5;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton9;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JMenuItem jMenuItem6;
  private javax.swing.JMenuItem jMenuItem7;
  private javax.swing.JMenuItem jMenuItem8;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JTabbedPane jTabbedPane2;
  private javax.swing.JTextField projectsField;
  private javax.swing.JTable projectsTable;
  private javax.swing.JComboBox searchGroupsBy;
  private javax.swing.JComboBox searchProjectsBy;
  private javax.swing.JComboBox searchStudentsBy;
  private javax.swing.JComboBox searchTeachersBy;
  private javax.swing.JComboBox searchTribunalsBy;
  private javax.swing.JTextField studentsField;
  private javax.swing.JTable studentsTable;
  private javax.swing.JTextField teachersField;
  private javax.swing.JTable teachersTable;
  private javax.swing.JTextField tribunalsField;
  private javax.swing.JTable tribunalsTable;
  // End of variables declaration//GEN-END:variables
}
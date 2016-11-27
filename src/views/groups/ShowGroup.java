package views.groups;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import models.Group;
import resources.TableData;
import resources.Util;

/**
 *
 * @author javier
 */
public class ShowGroup extends javax.swing.JFrame {
  private javax.swing.JFrame parent;
  private Group group;
  /**
   * Creates new form ShowGroup
   * @param parent
   * @param group
   */
  public ShowGroup(javax.swing.JFrame parent, Group group) {
    this.group = group;
    this.parent = parent;
    initComponents();
    addAttributes();
    loadGroupData();
    try {
      loadStudents();
      loadTeachers();
    } catch(Exception e) {
      Util.showWarning(this, String.format("Error por: %s", e.getMessage()));
    }
  }
  
  private void addAttributes() {
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.addWindowListener(new WindowListener() {
      @Override
      public void windowOpened(WindowEvent e) {
        parent.setEnabled(false);
      }

      @Override
      public void windowClosing(WindowEvent e) {
        parent.setEnabled(true);
      }

      @Override
      public void windowClosed(WindowEvent e) {}

      @Override
      public void windowIconified(WindowEvent e) {}

      @Override
      public void windowDeiconified(WindowEvent e) {}

      @Override
      public void windowActivated(WindowEvent e) {}

      @Override
      public void windowDeactivated(WindowEvent e) {}
    });
  }
  
  private void loadStudents() throws SQLException {
    TableData.loadStudents(studentsTable, this.group.getStudents());
  }
  
  private void loadTeachers() throws SQLException {
    TableData.loadTeachers(teachersTable, this.group.getTeachers());
  }
  
  private void loadGroupData() {
    if (this.group == null) return;
    //Group data
    this.groupName.setText(this.group.getName());
    this.groupDescription.setText(this.group.getDescription());
    this.groupComponentsNumber.setText(String.format("%d integrantes", this.group.getComponentsNumber()));
    this.groupTeacherName.setText(this.group.getTitularTeacher().getFullName());
    this.groupTeacherAddress.setText(this.group.getTitularTeacher().getAddress());
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    groupPanel = new javax.swing.JPanel();
    groupName = new javax.swing.JLabel();
    groupDescription = new javax.swing.JLabel();
    groupComponentsNumber = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    groupTeacherAddress = new javax.swing.JLabel();
    groupTeacherName = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jPanel10 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    teachersTable = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane8 = new javax.swing.JScrollPane();
    studentsTable = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem3 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    groupName.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
    groupName.setText("Nombre del grupo");

    groupDescription.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
    groupDescription.setText("Descripcion del grupo");

    groupComponentsNumber.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
    groupComponentsNumber.setText("Numero de componentes");

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del docente titular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

    groupTeacherAddress.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    groupTeacherAddress.setText("Dirección");

    groupTeacherName.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
    groupTeacherName.setText("Nombre");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(groupTeacherName)
          .addComponent(groupTeacherAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(groupTeacherName)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(groupTeacherAddress)
        .addContainerGap(12, Short.MAX_VALUE))
    );

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_image.png"))); // NOI18N

    jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profesores miembros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 12))); // NOI18N

    teachersTable.setBorder(null);
    teachersTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "CI", "Nombres", "Apellidos", "Dirección"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
    jScrollPane1.setViewportView(teachersTable);

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    jPanel10Layout.setVerticalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estudiantes que lo integran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Light", 0, 12))); // NOI18N

    studentsTable.setBorder(null);
    studentsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Número de registro", "CI", "Nombres", "Apellidos"
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
    jScrollPane8.setViewportView(studentsTable);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
    );

    jButton1.setText("Agregar profesor");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("Recargar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setText("Recargar");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton4.setText("Agregar estudiante");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout groupPanelLayout = new javax.swing.GroupLayout(groupPanel);
    groupPanel.setLayout(groupPanelLayout);
    groupPanelLayout.setHorizontalGroup(
      groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(groupPanelLayout.createSequentialGroup()
        .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(groupPanelLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(groupDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(groupComponentsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(94, 94, 94)
            .addComponent(jLabel2))
          .addGroup(groupPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(groupPanelLayout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1))
              .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(groupPanelLayout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)))))
        .addContainerGap(15, Short.MAX_VALUE))
    );
    groupPanelLayout.setVerticalGroup(
      groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(groupPanelLayout.createSequentialGroup()
        .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(groupPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(groupName)
            .addGap(18, 18, 18)
            .addComponent(groupDescription)
            .addGap(18, 18, 18)
            .addComponent(groupComponentsNumber)
            .addGap(18, 18, 18)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel2))
        .addGap(18, 18, 18)
        .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton1)
          .addComponent(jButton2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton4)
          .addComponent(jButton3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jMenu1.setText("Archivo");

    jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/guardarComo_16px.png"))); // NOI18N
    jMenuItem1.setText("Guardar");
    jMenu1.add(jMenuItem1);

    jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/impresora_16px.png"))); // NOI18N
    jMenuItem2.setText("Imprimir");
    jMenu1.add(jMenuItem2);

    jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
    jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar_16px.png"))); // NOI18N
    jMenuItem3.setText("Cerrar");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem3ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem3);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(groupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    dispose();
  }//GEN-LAST:event_jMenuItem3ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    new NewTeacherGroup(this, this.group).setVisible(true);
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    new NewStudentGroup(this, this.group).setVisible(true);
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    try {this.loadStudents();} catch (SQLException ex) {}
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {this.loadTeachers();} catch (SQLException ex) {}
  }//GEN-LAST:event_jButton2ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel groupComponentsNumber;
  private javax.swing.JLabel groupDescription;
  private javax.swing.JLabel groupName;
  private javax.swing.JPanel groupPanel;
  private javax.swing.JLabel groupTeacherAddress;
  private javax.swing.JLabel groupTeacherName;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel10;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane8;
  private javax.swing.JTable studentsTable;
  private javax.swing.JTable teachersTable;
  // End of variables declaration//GEN-END:variables
}
package views.groups;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import models.Group;
import models.Integrates;
import models.Student;
import models.Teacher;
import models.Tribunal;
import resources.Util;

/**
 *
 * @author Jhonathan Mejia Leon
 */
public class NewStudentGroup extends javax.swing.JFrame {
  private javax.swing.JFrame parent;
  private Integrates integrates;
  private Group group;
  
  /**
   * Creates new form NewTeacherTribunal
   * @param parent
   */
  public NewStudentGroup(javax.swing.JFrame parent, Group group) {
    this.group = group;
    this.parent = parent;
    initComponents();
    addAttributes();
    try {
      loadStudents();
    } catch(SQLException e) {
      System.out.printf("Error por: %s", e.getMessage());
    }
  }
  
  private void addAttributes() {
    setLocationRelativeTo(parent);
    setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    getContentPane().setBackground(Color.white);
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
    Student.allWithoutGroup().forEach(student -> {
      this.studentsCombo.addItem(String.format("%d- %s", student.getCi(), student.getName()));
    });
  }


  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel9 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    jButton2 = new javax.swing.JButton();
    studentsCombo = new javax.swing.JComboBox();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Añadir Profesor a Tribunal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(0, 102, 255))); // NOI18N

    jLabel3.setText("Estudiante");

    jButton2.setText("Añadir");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    studentsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un estudiante" }));

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel9Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButton2))
          .addGroup(jPanel9Layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addGap(0, 219, Short.MAX_VALUE))
          .addComponent(studentsCombo, 0, 287, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(studentsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButton2)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if (this.studentsCombo.getSelectedIndex() == 0) {
      Util.showWarning(this, "Debes seleccionar datos válidos");
      return;
    }
    int studentId = Util.getPKFromCombo(studentsCombo);

    Student student = Student.findBy("ci", String.valueOf(studentId));
    student.setGroupId(this.group.getId());
    try {
      if (student.save()) Util.showWarning(this, "Datos guardados");
      else Util.showWarning(this, "Datos no guardados");
    } catch(SQLException e) {
      Util.showWarning(this, String.format("Error por %s", e.getMessage()));
    }
    dispose();
    this.parent.setEnabled(true);
  }//GEN-LAST:event_jButton2ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JComboBox studentsCombo;
  // End of variables declaration//GEN-END:variables
}

package views.teachers;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import models.Teacher;
import models.Tribunal;
import resources.Util;


/**
 *
 * @author Jhonathan Mejia Leon
 */
public class NewTeacher extends javax.swing.JFrame {
  private javax.swing.JFrame parent;
  private Teacher teacher;
  
  public NewTeacher(javax.swing.JFrame parent, int teacherId) {
    this.parent = parent;
    this.teacher = Teacher.find(teacherId);
    initComponents();
    addAttributes();
    loadData();
  }  
  
  private void addAttributes() {
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
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
  
  private void loadData() {
    if (this.teacher == null) return;
    this.idField.setText(String.valueOf(this.teacher.getId()));
    this.idField.setEditable(false);
    this.namesField.setText(this.teacher.getName());
    this.lastNamesField.setText(this.teacher.getLastName());
    this.addressField.setText(this.teacher.getAddress());
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel9 = new javax.swing.JPanel();
    namesField = new javax.swing.JTextField();
    lastNamesField = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    addressField = new javax.swing.JTextField();
    jButton2 = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    idField = new javax.swing.JFormattedTextField(new Long(12345678));

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Personal-Nuevo Profesor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(0, 102, 255))); // NOI18N

    jLabel3.setText("Nombres:");

    jLabel4.setText("Apellidos:");

    jLabel1.setText("Dirección");

    jButton2.setText("Guardar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jLabel5.setText("Identificación");

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel9Layout.createSequentialGroup()
            .addComponent(idField)
            .addContainerGap())
          .addComponent(namesField)
          .addComponent(lastNamesField)
          .addComponent(addressField)
          .addGroup(jPanel9Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButton2))
          .addGroup(jPanel9Layout.createSequentialGroup()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(jLabel3)
              .addComponent(jLabel4)
              .addComponent(jLabel5))
            .addGap(0, 242, Short.MAX_VALUE))))
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(namesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lastNamesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButton2)
        .addGap(36, 36, 36))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    long id = Long.parseLong(this.idField.getValue().toString());
    String name = this.namesField.getText();
    String lastName = this.lastNamesField.getText();
    String address = this.addressField.getText();
    
    if (!Util.hasText(this.idField.getText()) 
        || !Util.hasText(name) 
        || !Util.hasText(lastName) 
        || !Util.hasText(address)) {
      Util.showWarning(this, "Los datos no son válidos");
      return;
    }
    if (this.teacher == null) {
      this.teacher = new Teacher(id, name, lastName, address);
      try {
        this.teacher.save();
        Util.showWarning(this, "Datos guardados");
      } catch(SQLException e) {
        Util.showWarning(this, e.getMessage());
      }
    } else {
      if (!this.teacher.getName().equals(name)) this.teacher.setName(name);
      if (!this.teacher.getLastName().equals(lastName)) this.teacher.setLastName(lastName);
      if (!this.teacher.getAddress().equals(address)) this.teacher.setAddress(address);
      try {
        this.teacher.update();
        Util.showWarning(this, "Datos actualizados");
      } catch(SQLException e) {
        Util.showWarning(this, e.getMessage());
      }
    }
    dispose();
    parent.setEnabled(true);
  }//GEN-LAST:event_jButton2ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField addressField;
  private javax.swing.JFormattedTextField idField;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JTextField lastNamesField;
  private javax.swing.JTextField namesField;
  // End of variables declaration//GEN-END:variables
}

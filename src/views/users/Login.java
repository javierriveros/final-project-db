/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.users;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import models.User;
import resources.Personalization;

/**
 *
 * @author Jhonathan Mejia Leon
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
      initComponents();  
      setAttributes();
    }
    
    private void setAttributes() {
      setTitle("SKYNET Login App");     
      getContentPane().setBackground(Color.white);
      setLocationRelativeTo(null);
      setResizable(false);
      Personalization.addPlaceholder(CajaUsuario, "name.code");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    Login = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    CajaContraseña = new javax.swing.JPasswordField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    CajaUsuario = new javax.swing.JTextField();
    Limpiar = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(0, 102, 255));

    jPanel1.setBackground(new java.awt.Color(0, 102, 255));
    jPanel1.setForeground(new java.awt.Color(255, 255, 255));
    jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    Login.setBackground(new java.awt.Color(0, 102, 255));
    Login.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
    Login.setForeground(new java.awt.Color(255, 255, 255));
    Login.setText("Login");
    Login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    Login.setContentAreaFilled(false);
    Login.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LoginActionPerformed(evt);
      }
    });
    jPanel1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 70, 30));

    jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("SKYNET Login App");
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

    jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Copyright By Mejia-Riveros Corporation");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 30));

    CajaContraseña.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
    CajaContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        CajaContraseñaKeyPressed(evt);
      }
    });
    jPanel1.add(CajaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 320, 30));

    jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Username");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

    jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Password");
    jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

    jLabel1.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Welcome");
    jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

    CajaUsuario.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
    CajaUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    CajaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        CajaUsuarioKeyPressed(evt);
      }
    });
    jPanel1.add(CajaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 320, 30));

    Limpiar.setBackground(new java.awt.Color(255, 255, 255));
    Limpiar.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
    Limpiar.setForeground(new java.awt.Color(255, 255, 255));
    Limpiar.setText("Limpiar");
    Limpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    Limpiar.setContentAreaFilled(false);
    Limpiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LimpiarActionPerformed(evt);
      }
    });
    jPanel1.add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 70, 30));

    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("_________________________________________");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
      limpiar();
    }//GEN-LAST:event_LimpiarActionPerformed

  private void CajaUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CajaUsuarioKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      doLogin();
    }
  }//GEN-LAST:event_CajaUsuarioKeyPressed

  private void CajaContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CajaContraseñaKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      doLogin();
    }
  }//GEN-LAST:event_CajaContraseñaKeyPressed

  private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
    doLogin();
  }//GEN-LAST:event_LoginActionPerformed

  private void doLogin() {
    if(!hasText(this.CajaUsuario.getText()) || !hasText(String.valueOf(this.CajaContraseña.getPassword()))) {
      JOptionPane.showMessageDialog(this, "Debes llenar todos los campos", "Rellena los campos", JOptionPane.ERROR_MESSAGE);
      return;
    }
    User user = User.find(CajaUsuario.getText(), String.valueOf(CajaContraseña.getPassword()));
    if (user == null) {
      JOptionPane.showMessageDialog(this, "El usuario no se ha encontrado en la Base de datos", "Revisa los campos", JOptionPane.ERROR_MESSAGE);
      return;
    }
    switch (user.getRole()) {
      case User.STUDENT:
        views.students.Index student = new views.students.Index();
        student.setVisible(true);
        student.setTitle("Student: " + user.getUsername());
        dispose();
        break;
      case User.TEACHER:
        views.students.Index index = new views.students.Index();
        index.setVisible(true);
        index.setTitle("Teacher: " + user.getUsername());
        dispose();
        break;
      case User.ADMIN:
        views.students.Index admin = new views.students.Index();
        admin.setVisible(true);
        admin.setTitle("Admin: " + user.getUsername());
        dispose();
        break;
      default:
        JOptionPane.showMessageDialog(this, "Este rol no es válido", "Error", JOptionPane.WARNING_MESSAGE);
        break;
    }
  }
  
  private boolean hasText(String text) {
    Pattern pattern = Pattern.compile("[a-zA-Z.\\s,]+");
    return pattern.matcher(text).matches();
  }
  
  private void limpiar(){
    CajaUsuario.setText("");
    CajaContraseña.setText("");
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    try {
      javax.swing.UIManager.setLookAndFeel(SyntheticaPlainLookAndFeel.class.getName());
      System.out.println("Completado");
    } catch (Exception e) {
      System.out.println("Fallo");
    }

    java.awt.EventQueue.invokeLater(() -> {
      new Login().setVisible(true);
    });

  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPasswordField CajaContraseña;
  private javax.swing.JTextField CajaUsuario;
  private javax.swing.JButton Limpiar;
  private javax.swing.JButton Login;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  // End of variables declaration//GEN-END:variables
}

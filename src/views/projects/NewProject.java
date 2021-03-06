package views.projects;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import models.Project;
import models.Student;
import models.Theme;
import models.Tribunal;
import resources.Util;

/**
 *
 * @author Jhonathan Mejia Leon
 */
public class NewProject extends javax.swing.JFrame {
  private javax.swing.JFrame parent;
  private Project project;
  /**
   * Creates new form ReporteEstudiantes
   * @param parent
   * @param orderNumber
   */
  public NewProject(javax.swing.JFrame parent, int orderNumber) {
    this.parent = parent;
    this.project = Project.find(orderNumber);
    initComponents();
    addAttributes();
    try {
      loadProjectData();
      loadStudents();
      loadTribunals();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  private String now() {
    GregorianCalendar calendar = new GregorianCalendar();
    return String.format(
      "%d-%d-%d %d:%d:%d", 
      calendar.get(Calendar.YEAR), 
      calendar.get(Calendar.MONTH), 
      calendar.get(Calendar.MONTH),
      calendar.get(Calendar.HOUR_OF_DAY),
      calendar.get(Calendar.MINUTE),
      calendar.get(Calendar.SECOND)
    );
  }
  
  private void loadStudents() throws SQLException {
    Student.allWithoutProject().forEach(student -> {
      this.studentsCombo.addItem(String.format("%d- %s", student.getRegistrationNumber(), student.getName()));
    });
  }
  
  private void loadTribunals() throws SQLException {
    Tribunal.all().forEach(tribunal -> {
      this.tribunalsCombo.addItem(String.format("%d- %s", tribunal.getId(), tribunal.getTestPlace()));
    });
  }
  
  private void loadProjectData() {
    if (this.project == null) {
      this.startDateField.setText(now());
      this.endDateField.setText(now());
      return;
    }
    this.orderNumberField.setEditable(false);
    this.themeField.setEditable(false);
    this.startDateField.setEditable(false);
    this.orderNumberField.setValue(this.project.getOrderNumber());
    this.themeField.setText(this.project.getTheme().getTitle());
    this.startDateField.setText(this.project.getStartDate().toString());
    if (this.project.getEndDate() == null) this.endDateField.setText(now());
    else this.endDateField.setText(this.project.getEndDate().toString());
    this.statusCombo.setSelectedIndex(this.project.getStatus().equals("No evaluado") ? 0 : 1);
  }
  
  private void addAttributes() {
    setLocationRelativeTo(this.parent);
    setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    this.startDateField.setText(now());
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

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel9 = new javax.swing.JPanel();
    themeField = new javax.swing.JTextField();
    startDateField = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    studentsCombo = new javax.swing.JComboBox();
    jButton2 = new javax.swing.JButton();
    orderNumberField = new javax.swing.JFormattedTextField(1);
    jLabel5 = new javax.swing.JLabel();
    tribunalsCombo = new javax.swing.JComboBox();
    endDateField = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    statusCombo = new javax.swing.JComboBox();
    jLabel7 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información-Nuevo Proyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(0, 102, 255))); // NOI18N

    jLabel2.setText("Número de orden:");

    jLabel3.setText("Tema:");

    jLabel4.setText("Fecha de Inicio:");

    jLabel1.setText("Estudiante:");

    studentsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un estudiante" }));

    jButton2.setText("Añadir");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jLabel5.setText("Tribunal");

    tribunalsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un tribunal" }));

    jLabel6.setText("Fecha de final:");

    statusCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No evaluado", "Evaluado" }));

    jLabel7.setText("Estado");

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(orderNumberField)
          .addComponent(themeField, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(startDateField, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(studentsCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 393, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButton2))
          .addComponent(tribunalsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel9Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(endDateField, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(statusCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel9Layout.createSequentialGroup()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jLabel3)
              .addComponent(jLabel4)
              .addComponent(jLabel5)
              .addComponent(jLabel6)
              .addComponent(jLabel7))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(orderNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(themeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel6)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
        .addComponent(jLabel5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(tribunalsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(studentsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton2)
        .addContainerGap())
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
    int orderNumber = Integer.parseInt(this.orderNumberField.getValue().toString());
    String theme = this.themeField.getText();
    String startDate = this.startDateField.getText();
    String endDate = this.endDateField.getText().length() == 0 ? null : this.endDateField.getText();
    
    if (!Util.hasText(theme) || !Util.hasText(startDate)) {
      Util.showWarning(this, "Debes rellenar todos los campos");
      return;
    }
    if (this.studentsCombo.getSelectedIndex() == 0 
        || this.tribunalsCombo.getSelectedIndex() == 0
        && this.project == null) {
      Util.showWarning(this, "Debes seleccionar datos válidos");
      return;
    }
    Timestamp startDateT = Timestamp.valueOf(startDate);
    Timestamp endDateT = endDate == null ? null : Timestamp.valueOf(endDate);
    int tribunalId = Util.getPKFromCombo(tribunalsCombo);
    int studentId = Util.getPKFromCombo(studentsCombo);
    String status = statusCombo.getSelectedItem().toString();
    if (this.project == null) {
      this.project = new Project(orderNumber, startDateT, endDateT, tribunalId, studentId, new Theme(0, theme));
      try {
        if (this.project.save()) {
          Util.showWarning(this, "Datos guardados");
        } else {
          Util.showWarning(this, "Datos no guardados");
        }
      } catch(Exception e) {
        Util.showWarning(this, e.getMessage());
      }
    } else {
      if (this.project.getStartDate() != startDateT)
        this.project.setStartDate(startDateT);
      if (this.project.getEndDate() != endDateT)
        this.project.setEndDate(endDateT);
      if (!this.project.getStatus().equals(status))
        this.project.setStatus(status);
      
       try {
        if (this.project.update()) {
          Util.showWarning(this, "Datos actualizados");
        } else {
          Util.showWarning(this, "Datos no actualizados");
        }
      } catch(Exception e) {
        Util.showWarning(this, e.getMessage());
      }
    }
    dispose();
    parent.setEnabled(true);
  }//GEN-LAST:event_jButton2ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField endDateField;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JFormattedTextField orderNumberField;
  private javax.swing.JTextField startDateField;
  private javax.swing.JComboBox statusCombo;
  private javax.swing.JComboBox studentsCombo;
  private javax.swing.JTextField themeField;
  private javax.swing.JComboBox tribunalsCombo;
  // End of variables declaration//GEN-END:variables
}

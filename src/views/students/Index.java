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
import javax.swing.table.DefaultTableModel;
import models.Student;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

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
    DefaultTableModel model =  (DefaultTableModel) studentsTable.getModel();
    LinkedList<Student> students = Student.all();
    students.forEach(student -> {
      model.addRow(new Object[] {
        student.getRegistrationNumber(),
        student.getName(),
        student.getLastName()
      });
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

    jScrollPane1 = new javax.swing.JScrollPane();
    studentsTable = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    studentsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Code", "Name", "Last Name"
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
    jScrollPane1.setViewportView(studentsTable);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) throws ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    java.awt.EventQueue.invokeLater(() -> new Index().setVisible(true));
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable studentsTable;
  // End of variables declaration//GEN-END:variables
}

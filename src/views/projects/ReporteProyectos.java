package views.projects;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import models.Project;


/**
 *
 * @author Mejia & Riveros Corp.
 */
public class ReporteProyectos extends javax.swing.JFrame {
  private javax.swing.JFrame parent;
  /**
   * Creates new form ReporteProyectos
   * @param parent
   */
  public ReporteProyectos(javax.swing.JFrame parent) {
    this.parent = parent;
    initComponents();
    addAttributes();
    try {
      addData();
    } catch(SQLException e) {}
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
  
  private void addData() throws SQLException {
    LinkedList<Project> projects = Project.all();
    DefaultTableModel model = (DefaultTableModel) projectsTable.getModel();
    projects.forEach(project -> {
      model.addRow(new Object[] {
        project.getOrderNumber(),
        project.getTheme().getTitle(),
        project.getTribunal().getId(),
        project.getTribunal().getTestPlace(),
        project.getStudent().getCi(),
        project.getStudent().getName(),
        project.getStartDate(),
        project.getEndDate(),
        project.getStatus(),
        project.getDuration() == null ? "En curso" : project.getDuration()
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

    jPanel3 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    projectsTable = new javax.swing.JTable();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem3 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proyectos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(0, 102, 255))); // NOI18N

    projectsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Número de orden", "Tema", "ID Tribunal", "Lugar Tribunal", "Cod Estudiante", "Nombres Estudiante", "Inicio", "Final", "Estado", "Duración"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(projectsTable);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
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
      .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    dispose();
    this.parent.setEnabled(true);
  }//GEN-LAST:event_jMenuItem3ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable projectsTable;
  // End of variables declaration//GEN-END:variables
}

package views.students;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import models.Student;
import models.User;
import resources.TableData;
import resources.Util;

/**
 *
 * @author Jhonathan Mejia Leon
 */
public class ViewStudent extends javax.swing.JFrame {
  private User user;
  private Student student;
  
  //Sorters
  private TableRowSorter teachersSorter;
  private TableRowSorter projectsSorter;
  private TableRowSorter tribunalsSorter;
  private TableRowSorter groupsSorter;
  
  /**
   * Creates new form Ventana
   * @param user
   */
  public ViewStudent(User user) {
    this.user = user;
    this.student = Student.find(Integer.parseInt(String.valueOf(user.getRoleReference())));
    initComponents();
    addAttributes();
    addMyData();
    addSorters();
    System.out.println(this.student);
    try {
      loadData();
    } catch(SQLException e) {
      System.out.printf("Error por: %s", e.getMessage());
    }
  }

  private void addAttributes() {
    setLocationRelativeTo(null);
    setTitle(String.format("Usted se ha identificado como: %s", this.user.getUsername()));
    String text = "Escriba aquí para buscar";
    Util.addPlaceholder(groupsField, text);
    Util.addPlaceholder(projectsField, text);
    Util.addPlaceholder(tribunalsField, text);
  }
  
  private void addMyData() {
    this.codeField.setText(String.valueOf(this.student.getCi()));
    this.namesField.setText(this.student.getName());
    this.lastNamesField.setText(this.student.getLastName());
  }
  
  private void loadData() throws SQLException {
    TableData.loadTeachers(teachersTable);
    TableData.loadProjects(projectsTable);
    TableData.loadTribunals(tribunalsTable);
    TableData.loadGroups(groupsTable);
  }
  
  private void addSorters() {
    teachersSorter = new TableRowSorter(teachersTable.getModel());
    teachersTable.setRowSorter(teachersSorter);
    
    projectsSorter = new TableRowSorter(projectsTable.getModel());
    projectsTable.setRowSorter(projectsSorter);
    
    tribunalsSorter = new TableRowSorter(tribunalsTable.getModel());
    tribunalsTable.setRowSorter(tribunalsSorter);
    
    groupsSorter = new TableRowSorter(groupsTable.getModel());
    groupsTable.setRowSorter(tribunalsSorter);
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
    searchTeachersBy = new javax.swing.JComboBox();
    teachersField = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jPanel4 = new javax.swing.JPanel();
    searchProjectsBy = new javax.swing.JComboBox();
    projectsField = new javax.swing.JTextField();
    jButton15 = new javax.swing.JButton();
    jButton16 = new javax.swing.JButton();
    jScrollPane4 = new javax.swing.JScrollPane();
    projectsTable = new javax.swing.JTable();
    jPanel5 = new javax.swing.JPanel();
    tribunalsField = new javax.swing.JTextField();
    searchTribunalsBy = new javax.swing.JComboBox();
    jButton19 = new javax.swing.JButton();
    jButton20 = new javax.swing.JButton();
    jScrollPane5 = new javax.swing.JScrollPane();
    tribunalsTable = new javax.swing.JTable();
    jPanel3 = new javax.swing.JPanel();
    searchGroupsBy = new javax.swing.JComboBox();
    groupsField = new javax.swing.JTextField();
    jButton11 = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    groupsTable = new javax.swing.JTable();
    jPanel6 = new javax.swing.JPanel();
    jPanel7 = new javax.swing.JPanel();
    codeField = new javax.swing.JTextField();
    namesField = new javax.swing.JTextField();
    lastNamesField = new javax.swing.JTextField();
    jButton2 = new javax.swing.JButton();
    jPanel8 = new javax.swing.JPanel();
    orderNumberField = new javax.swing.JTextField();
    startDateField = new javax.swing.JTextField();
    themeCombo = new javax.swing.JComboBox<>();
    statusField = new javax.swing.JTextField();
    jButton6 = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem8 = new javax.swing.JMenuItem();
    jMenuItem7 = new javax.swing.JMenuItem();
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

    searchTeachersBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por:", "Id", "Nombres", "Apellidos", "Direccion" }));

    teachersField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        teachersFieldKeyPressed(evt);
      }
    });

    jButton1.setText("Refresh");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton4.setText("Ver");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(searchTeachersBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(teachersField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
          .addComponent(searchTeachersBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(teachersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1)
          .addComponent(jButton4))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Profesores", jPanel1);

    searchProjectsBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por:", "Numero de Orden", "Tema" }));

    projectsField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        projectsFieldKeyPressed(evt);
      }
    });

    jButton15.setText("Refresh");
    jButton15.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton15ActionPerformed(evt);
      }
    });

    jButton16.setText("Ver");

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
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(searchProjectsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(projectsField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton16)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton15))
          .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(searchProjectsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(projectsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton15)
          .addComponent(jButton16))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Proyectos", jPanel4);

    tribunalsField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        tribunalsFieldKeyPressed(evt);
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
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jScrollPane5)
          .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(searchTribunalsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tribunalsField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
            .addComponent(jButton20)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton19)))
        .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(searchTribunalsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tribunalsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton19)
          .addComponent(jButton20))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Tribunal", jPanel5);

    searchGroupsBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por:", "Id", "Nombre" }));

    groupsField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        groupsFieldKeyPressed(evt);
      }
    });

    jButton11.setText("Refresh");
    jButton11.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton11ActionPerformed(evt);
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
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(searchGroupsBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(groupsField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton11))
          .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(searchGroupsBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(groupsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton11))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Grupo", jPanel3);

    jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(0, 102, 255))); // NOI18N

    codeField.setEditable(false);
    codeField.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

    namesField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombres"));

    lastNamesField.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellidos"));

    jButton2.setText("Modificar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(codeField)
          .addComponent(lastNamesField)
          .addComponent(namesField)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
            .addGap(0, 259, Short.MAX_VALUE)
            .addComponent(jButton2)))
        .addContainerGap())
    );
    jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(namesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(lastNamesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton2)
        .addContainerGap(16, Short.MAX_VALUE))
    );

    jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proyecto de Fin de Carrera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 12), new java.awt.Color(0, 102, 255))); // NOI18N

    orderNumberField.setEditable(false);
    orderNumberField.setBorder(javax.swing.BorderFactory.createTitledBorder("Número de orden"));

    startDateField.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de inicio"));

    themeCombo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tema"));

    statusField.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

    jButton6.setText("Modificar");

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(startDateField, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(orderNumberField)
          .addComponent(themeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(statusField)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
            .addGap(0, 376, Short.MAX_VALUE)
            .addComponent(jButton6)))
        .addContainerGap())
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addComponent(orderNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(themeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton6)
        .addContainerGap())
    );

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addGap(6, 6, 6)
        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Mis Datos", jPanel6);

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
      .addComponent(jTabbedPane2)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    dispose();
    new views.users.Login().setVisible(true);
  }//GEN-LAST:event_jMenuItem7ActionPerformed

  private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
    new views.Historial().setVisible(true);
  }//GEN-LAST:event_jMenuItem8ActionPerformed

  private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    try {TableData.loadGroups(groupsTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton11ActionPerformed

  private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
    try {TableData.loadTribunals(tribunalsTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton19ActionPerformed

  private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
    try {TableData.loadProjects(projectsTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton15ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {TableData.loadTeachers(teachersTable);}catch(SQLException e){}
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String code = this.codeField.getText();
    String name = this.namesField.getText();
    String lastName = this.lastNamesField.getText();
    
    if (!Util.hasText(code) || !Util.hasText(name) || !Util.hasText(lastName)) {
      JOptionPane.showMessageDialog(this, "Debes llenar todos los campos", "Rellena los campos", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (!code.equals(this.student.getCi())) this.student.setCi(Integer.parseInt(code));
    if (!name.equals(this.student.getName())) this.student.setName(name);
    if (!lastName.equals(this.student.getLastName())) this.student.setLastName(lastName);
    try {
      this.student.update();
      JOptionPane.showMessageDialog(this, "Datos guardados", "OK", JOptionPane.INFORMATION_MESSAGE);
    } catch(SQLException e) {
      JOptionPane.showMessageDialog(this, String.format("No se ha podido actualizar por: %s", e.getMessage()), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_jButton2ActionPerformed

  private void teachersFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teachersFieldKeyPressed
    if(searchTeachersBy.getSelectedIndex() == 0) return;
    teachersSorter.setRowFilter(RowFilter.regexFilter(teachersField.getText(), searchTeachersBy.getSelectedIndex()-1));
  }//GEN-LAST:event_teachersFieldKeyPressed

  private void projectsFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_projectsFieldKeyPressed
    if(searchProjectsBy.getSelectedIndex() == 0) return;
    projectsSorter.setRowFilter(RowFilter.regexFilter(projectsField.getText(), searchProjectsBy.getSelectedIndex()-1));
  }//GEN-LAST:event_projectsFieldKeyPressed

  private void tribunalsFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tribunalsFieldKeyPressed
    if(searchTribunalsBy.getSelectedIndex() == 0) return;
    tribunalsSorter.setRowFilter(RowFilter.regexFilter(tribunalsField.getText(), searchTribunalsBy.getSelectedIndex()-1));
  }//GEN-LAST:event_tribunalsFieldKeyPressed

  private void groupsFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_groupsFieldKeyPressed
    if(searchGroupsBy.getSelectedIndex() == 0) return;
    groupsSorter.setRowFilter(RowFilter.regexFilter(groupsField.getText(), searchGroupsBy.getSelectedIndex()-1));
  }//GEN-LAST:event_groupsFieldKeyPressed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField codeField;
  private javax.swing.JTextField groupsField;
  private javax.swing.JTable groupsTable;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton11;
  private javax.swing.JButton jButton15;
  private javax.swing.JButton jButton16;
  private javax.swing.JButton jButton19;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton20;
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton6;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem7;
  private javax.swing.JMenuItem jMenuItem8;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JTabbedPane jTabbedPane2;
  private javax.swing.JTextField lastNamesField;
  private javax.swing.JTextField namesField;
  private javax.swing.JTextField orderNumberField;
  private javax.swing.JTextField projectsField;
  private javax.swing.JTable projectsTable;
  private javax.swing.JComboBox searchGroupsBy;
  private javax.swing.JComboBox searchProjectsBy;
  private javax.swing.JComboBox searchTeachersBy;
  private javax.swing.JComboBox searchTribunalsBy;
  private javax.swing.JTextField startDateField;
  private javax.swing.JTextField statusField;
  private javax.swing.JTextField teachersField;
  private javax.swing.JTable teachersTable;
  private javax.swing.JComboBox<String> themeCombo;
  private javax.swing.JTextField tribunalsField;
  private javax.swing.JTable tribunalsTable;
  // End of variables declaration//GEN-END:variables
}

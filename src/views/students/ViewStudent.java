package views.students;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import models.Group;
import models.Project;
import models.Student;
import models.Teacher;
import models.User;
import models.Tribunal;
import resources.TableData;
import resources.Util;
import views.About;

/**
 *
 * @author Mejia & Riveros Corp.
 */
public class ViewStudent extends javax.swing.JFrame {
  private User user;
  private Student student;
  private Group group;
  private Project project;
  private Tribunal tribunal;
  private Teacher teacher;
  
  //Sorters
  private TableRowSorter teachersSorter;
  
  /**
   * Creates new form Ventana
   * @param user
   */
  public ViewStudent(User user) {
    this.user = user;
    this.student = Student.find(Integer.parseInt(String.valueOf(user.getRoleReference())));
    this.group = Group.find(student.getGroupId());
    this.project = Project.find(student.getOrderNumber());
    this.teacher = Teacher.find(this.student.getTeacherId());
    
    initComponents();
    addAttributes();
    try {
      loadData();
      addMyData();
      loadProjectData();
      loadGroupData();
      loadTeacherData();
      if (project != null) {
        this.tribunal = project.getTribunal();
        loadTribunalData();
      }
      addSorters();
    } catch(Exception e) {
      System.out.printf("%s",e.getClass().getName());
    }
  }

  private void addAttributes() {
    setLocationRelativeTo(null);
    setTitle(String.format("Usted se ha identificado como: %s - Estudiante", this.user.getUsername()));
    String text = "Escriba aquí para buscar";
    Util.addPlaceholder(teachersField, text);
  }
  
  private void addMyData() {
    this.codeField.setText(String.valueOf(this.student.getCi()));
    this.namesField.setText(this.student.getName());
    this.lastNamesField.setText(this.student.getLastName());
  }
  
  private void loadTeacherData() {
    if (this.project == null) return;
    this.projectTeacherName.setText(this.teacher.getFullName());
    this.projectTeacherAddress.setText(this.teacher.getAddress());
  }
  
  private void loadProjectData() {
    if (this.project == null) {
      loadDefaultDataForProject();
      return;
    }
    //Project data
    this.projectTheme.setText(this.project.getTheme().getTitle());
    this.projectStartDate.setText("Fecha de inicio: " + this.project.getStartDate().toString());
    this.projectEndDate.setText("Fecha final: " + this.project.getEndDate() == null ? this.project.getDuration() : this.project.getEndDate().toString());
    this.projectDuration.setText("Duración: " + this.project.getDuration());
    this.projectState.setText(this.project.getStatus());
  }
  
  private void loadDefaultDataForProject() {
    this.projectTheme.setText("Aún no has creado un proyecto");
    this.projectStartDate.setText("Contacta con el administrador");
    this.projectEndDate.setText("");
    this.projectDuration.setText("");
    this.projectState.setText("");
    this.projectTeacherName.setText("");
    this.projectTeacherAddress.setText("");
    
    this.tribunalPresentationPlace.setText("");
    this.tribunalComponentsNumber.setText("");
    this.tribunalTeacherName.setText("");
    this.tribunalTeacherAddress.setText("");
  }
  
  private void loadGroupData() {
    if (this.group == null) return;
    //Group date
    this.groupName.setText(this.group.getName());
    this.groupDescription.setText(this.group.getDescription());
    this.groupComponentsNumber.setText(String.format("%d integrantes", this.group.getComponentsNumber()));
    this.groupTeacherName.setText(this.group.getTitularTeacher().getFullName());
    this.groupTeacherAddress.setText(this.group.getTitularTeacher().getAddress());
  }
  
  private void loadTribunalData() {
    //Tribunal data
    if (this.tribunal == null) return;
    this.tribunalPresentationPlace.setText("Lugar de presentación: " + this.tribunal.getTestPlace());
    this.tribunalComponentsNumber.setText(String.format("%d integrantes", this.tribunal.getComponentsNumber()));
    this.tribunalTeacherName.setText(this.tribunal.getTitularTeacher().getFullName());
    this.tribunalTeacherAddress.setText(this.tribunal.getTitularTeacher().getAddress());
  }
  
  private void loadData() throws SQLException {
    TableData.loadTeachers(teachersTable, student.getTeachersWhoHelpMe());
  }
  
  private void addSorters() {
    teachersSorter = new TableRowSorter(teachersTable.getModel());
    teachersTable.setRowSorter(teachersSorter);
  }
  
  private String getCurrentTime() {
    GregorianCalendar calendar = new GregorianCalendar();
    return String.format("%d-%d-%d %d:%d:%d",calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
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
    searchTeachersBy = new javax.swing.JComboBox();
    teachersField = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    viewTeacher = new javax.swing.JButton();
    jPanel10 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    teachersTable = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    projectTheme = new javax.swing.JLabel();
    projectStartDate = new javax.swing.JLabel();
    projectEndDate = new javax.swing.JLabel();
    projectDuration = new javax.swing.JLabel();
    projectState = new javax.swing.JLabel();
    jPanel4 = new javax.swing.JPanel();
    tribunalPresentationPlace = new javax.swing.JLabel();
    tribunalComponentsNumber = new javax.swing.JLabel();
    jPanel5 = new javax.swing.JPanel();
    projectTeacherAddress = new javax.swing.JLabel();
    projectTeacherName = new javax.swing.JLabel();
    jPanel9 = new javax.swing.JPanel();
    tribunalTeacherName = new javax.swing.JLabel();
    tribunalTeacherAddress = new javax.swing.JLabel();
    groupPanel = new javax.swing.JPanel();
    groupName = new javax.swing.JLabel();
    groupDescription = new javax.swing.JLabel();
    groupComponentsNumber = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    groupTeacherAddress = new javax.swing.JLabel();
    groupTeacherName = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jPanel6 = new javax.swing.JPanel();
    jPanel7 = new javax.swing.JPanel();
    codeField = new javax.swing.JTextField();
    namesField = new javax.swing.JTextField();
    lastNamesField = new javax.swing.JTextField();
    jButton2 = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem7 = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

    viewTeacher.setText("Ver");

    jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profesores colaboradores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 12))); // NOI18N

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
      .addGroup(jPanel10Layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(searchTeachersBy, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(teachersField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(viewTeacher)
            .addGap(18, 18, 18)
            .addComponent(jButton1)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(searchTeachersBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(teachersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1)
          .addComponent(viewTeacher))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Profesores", jPanel1);

    projectTheme.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
    projectTheme.setText("Tema del proyecto");

    projectStartDate.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
    projectStartDate.setText("Fecha de inicio");

    projectEndDate.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
    projectEndDate.setText("Fecha de terminación");

    projectDuration.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
    projectDuration.setText("Duracion");

    projectState.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
    projectState.setText("Estado");

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tribunal que lo evalua"));

    tribunalPresentationPlace.setText("Lugar de presentación");

    tribunalComponentsNumber.setText("Número de integrantes");

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(tribunalPresentationPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(tribunalComponentsNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addComponent(tribunalPresentationPlace)
        .addGap(18, 18, 18)
        .addComponent(tribunalComponentsNumber)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Docente que me asesora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

    projectTeacherAddress.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
    projectTeacherAddress.setText("Dirección del profesor");

    projectTeacherName.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
    projectTeacherName.setText("Nombre del profesor");

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(projectTeacherName, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addComponent(projectTeacherAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addComponent(projectTeacherName)
        .addGap(18, 18, 18)
        .addComponent(projectTeacherAddress)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Docente titular del tribunal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

    tribunalTeacherName.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
    tribunalTeacherName.setText("Nombre del docente");

    tribunalTeacherAddress.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
    tribunalTeacherAddress.setText("Dirección del docente");

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tribunalTeacherName, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
          .addComponent(tribunalTeacherAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addComponent(tribunalTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(12, 12, 12)
        .addComponent(tribunalTeacherAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(17, 17, 17)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(projectTheme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(projectEndDate)
              .addComponent(projectDuration)
              .addComponent(projectState)
              .addComponent(projectStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(19, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(projectTheme)
            .addGap(18, 18, 18)
            .addComponent(projectStartDate)
            .addGap(18, 18, 18)
            .addComponent(projectEndDate)
            .addGap(18, 18, 18)
            .addComponent(projectDuration)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(projectState)
            .addGap(18, 18, 18)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(31, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Mi Proyecto", jPanel2);

    groupName.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
    groupName.setText("No estás en un grupo");

    groupDescription.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
    groupDescription.setText("Descripcion del grupo");

    groupComponentsNumber.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
    groupComponentsNumber.setText("Numero de componentes");

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del docente titular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 14))); // NOI18N

    groupTeacherAddress.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
    groupTeacherAddress.setText("Dirección");

    groupTeacherName.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
    groupTeacherName.setText("Nombre");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(groupTeacherAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(groupTeacherName))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(groupTeacherName)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(groupTeacherAddress)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_image.png"))); // NOI18N

    javax.swing.GroupLayout groupPanelLayout = new javax.swing.GroupLayout(groupPanel);
    groupPanel.setLayout(groupPanelLayout);
    groupPanelLayout.setHorizontalGroup(
      groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(groupPanelLayout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(groupDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(groupName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(groupComponentsNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(59, 59, 59)
        .addComponent(jLabel2)
        .addContainerGap(79, Short.MAX_VALUE))
    );
    groupPanelLayout.setVerticalGroup(
      groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(groupPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(groupName)
        .addGap(18, 18, 18)
        .addComponent(groupDescription)
        .addGap(18, 18, 18)
        .addComponent(groupComponentsNumber)
        .addGap(18, 18, 18)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(groupPanelLayout.createSequentialGroup()
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 66, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Mi grupo", groupPanel);

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
            .addGap(0, 257, Short.MAX_VALUE)
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

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/student.png"))); // NOI18N

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addGap(6, 6, 6)
        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(10, Short.MAX_VALUE))
    );

    jTabbedPane2.addTab("Mis Datos", jPanel6);

    jMenu1.setText("Archivo");

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
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
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

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {TableData.loadTeachers(teachersTable, Teacher.all());}catch(SQLException e){}
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
      if (this.student.update())
        JOptionPane.showMessageDialog(this, "Datos guardados", "OK", JOptionPane.INFORMATION_MESSAGE);
      else
        JOptionPane.showMessageDialog(this, "Datos no guardados", "OK", JOptionPane.ERROR_MESSAGE);
    } catch(SQLException e) {
      JOptionPane.showMessageDialog(this, String.format("No se ha podido actualizar por: %s", e.getMessage()), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_jButton2ActionPerformed

  private void teachersFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teachersFieldKeyPressed
    if(searchTeachersBy.getSelectedIndex() == 0 || teachersTable.getRowCount() == 0) return;
    teachersSorter.setRowFilter(RowFilter.regexFilter(teachersField.getText(), searchTeachersBy.getSelectedIndex()-1));
  }//GEN-LAST:event_teachersFieldKeyPressed

  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    new About(this).setVisible(true);
  }//GEN-LAST:event_jMenuItem2ActionPerformed
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField codeField;
  private javax.swing.JLabel groupComponentsNumber;
  private javax.swing.JLabel groupDescription;
  private javax.swing.JLabel groupName;
  private javax.swing.JPanel groupPanel;
  private javax.swing.JLabel groupTeacherAddress;
  private javax.swing.JLabel groupTeacherName;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel10;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane2;
  private javax.swing.JTextField lastNamesField;
  private javax.swing.JTextField namesField;
  private javax.swing.JLabel projectDuration;
  private javax.swing.JLabel projectEndDate;
  private javax.swing.JLabel projectStartDate;
  private javax.swing.JLabel projectState;
  private javax.swing.JLabel projectTeacherAddress;
  private javax.swing.JLabel projectTeacherName;
  private javax.swing.JLabel projectTheme;
  private javax.swing.JComboBox searchTeachersBy;
  private javax.swing.JTextField teachersField;
  private javax.swing.JTable teachersTable;
  private javax.swing.JLabel tribunalComponentsNumber;
  private javax.swing.JLabel tribunalPresentationPlace;
  private javax.swing.JLabel tribunalTeacherAddress;
  private javax.swing.JLabel tribunalTeacherName;
  private javax.swing.JButton viewTeacher;
  // End of variables declaration//GEN-END:variables
}

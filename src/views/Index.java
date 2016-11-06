package views;

import java.util.LinkedList;
import controllers.StudentsController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Student;
/*
//
StudentsController studentsController = new StudentsController();
LinkedList<Student> students = studentsController.index();
System.out.println(students);
*/

public class Index {
  public static void main(String ...app) {
    StudentsController studentsController = new StudentsController();
    LinkedList<Student> students = studentsController.index();
    System.out.println(students);
    
    try {
      Student student = Student.find(160003532);
      System.out.println(student);
    } catch (SQLException ex) {
      Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}

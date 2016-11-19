package views;

import controllers.StudentsController;
import java.sql.SQLException;

public class Index {
  public static void main(String ...app) throws SQLException {
    StudentsController studentsController = new StudentsController();
    System.out.println(studentsController.index());
  }
}

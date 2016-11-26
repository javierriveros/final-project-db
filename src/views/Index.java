package views;

import java.sql.SQLException;
import models.*;

public class Index {
  public static void main(String ...app) throws SQLException {
    Helps.all().forEach(help -> {
      System.out.println(Teacher.find(help.getTeacherId()));
      System.out.println(Student.find(help.getStudentRegistrationNumber()));
    });
  }
}

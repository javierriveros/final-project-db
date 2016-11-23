package views;

import java.sql.SQLException;
import models.*;

public class Index {
  public static void main(String ...app) throws SQLException {
    User user = User.find(3);
    Teacher teacher = Teacher.find(user.getRoleReference());
    System.out.println(teacher);
  }
}

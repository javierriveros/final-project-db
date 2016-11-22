package views;

import java.sql.SQLException;
import models.*;

public class Index {
  public static void main(String ...app) throws SQLException {
    System.out.println(User.all());
    User user = new User("mauricio.leal","leal", "student");
    user.save();
    System.out.println(User.all());
  }
}

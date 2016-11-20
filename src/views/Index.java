package views;

import java.sql.SQLException;
import models.Group;

public class Index {
  static int cont = 0;
  public static void main(String ...app) throws SQLException {
    System.out.println(Group.all());
  }
}

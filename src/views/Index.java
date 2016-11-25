package views;

import java.sql.SQLException;
import models.*;

public class Index {
  public static void main(String ...app) throws SQLException {
    System.out.println(Group.all());
  }
}

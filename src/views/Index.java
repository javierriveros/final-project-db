package views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;

public class Index {
  public static void main(String ...app) throws SQLException {
    Teacher.all().forEach(teacher -> {
      try {
        System.out.println(teacher);
        System.out.println(teacher.getGroupsWhereIAmMember());
      } catch (SQLException ex) {
        
      }
      System.out.println("\n---------------------------------\n");
    });
  }
}

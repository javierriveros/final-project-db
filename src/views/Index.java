package views;

import java.sql.SQLException;
import models.*;

public class Index {
  public static void main(String ...app) throws SQLException {
    User user = User.find(1);
    user.setUsername("javier");
    if(user.update()) System.out.println("Updated");
    else System.out.println("Not Updated");
  }
}

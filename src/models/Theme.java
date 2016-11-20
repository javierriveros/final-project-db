package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import resources.Connection;

/**
 * Project Theme Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Theme {
  private int orderNumber;
  private String title;

  public int getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    if (orderNumber > 0) 
      throw new NumberFormatException("Order Number must be greater than zero");
    this.orderNumber = orderNumber;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    if(title == null || title.length() <= 0)
      throw new NullPointerException("Name can't be empty or null");
    this.title = title;
  }

  public Theme(int orderNumber, String title) {
    this.orderNumber = orderNumber;
    this.title = title;
  }
  
  @Override
  public String toString() {
    return String.format("order_number: %d, title: %s", this.orderNumber, this.title);
  }
  
  /**
   * Return all themes at DB
   * @return themes
   * @throws java.sql.SQLException
   */
  public static LinkedList<Theme> all() throws SQLException {
    LinkedList<Theme> themes = new LinkedList<>();
    Connection con = Connection.getInstance();
    
    try (Statement sm = con.getCon().createStatement()) {
      ResultSet rs = sm.executeQuery("SELECT * FROM themes");
      while (rs.next())
        themes.add(getThemeFromResultSet(rs));
    }

    return themes;
  }
  
  /**
   * Find a theme by the order Number
   * @param orderNumber
   * @return 
   */
  public static Theme find(int orderNumber) {
    return findBy("order_number", String.valueOf(orderNumber));
  }
  
  /**
   * Find a theme by the specified field
   * @param field
   * @param value
   * @return 
   */
  public static Theme findBy(String field, String value) {
    Theme theme = null;
    try {
      Connection con = Connection.getInstance();
      try (Statement sm = con.getCon().createStatement()) {
        ResultSet rs = sm.executeQuery(String.format("SELECT * FROM themes WHERE %s='%s'", field, value));
        while (rs.next())
          theme = getThemeFromResultSet(rs);
      }
    } catch(SQLException  sql){
      java.util.logging.Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, sql);
    }
    return theme;
  }
  
  /**
   * Save the current theme
   * @return <code>true</code> if could be saved or <code>false</code> if else
     * @throws java.sql.SQLException
   */
  public boolean save() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("INSERT INTO themes (order_number, title) VALUES ('%d', '%s')", this.orderNumber, this.title))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  /**
   * Destroy the current theme
   * @return <code>true</code> if could be destroyed or <code>false</code> if else
   * @throws java.sql.SQLException
   */
  public boolean destroy() throws SQLException {
    Connection con = Connection.getInstance();
    try (
      PreparedStatement ps = con.getCon().prepareStatement(String.format("DELETE FROM themes WHERE order_number='%d'", this.orderNumber))) {
      try {
        ps.execute();
        return true;
      } catch(SQLException e) {
        System.out.printf("Hubo un error por %s", e.getMessage());
        return false;
      }
    }
  }
  
  /**
   * Return a new theme with the DB values
   * @param rs
   * @return 
   */
  private static Theme getThemeFromResultSet(ResultSet rs) {
    try {
      return new Theme(rs.getInt("order_number"), rs.getString("title"));
    } catch(SQLException ex) {
      return null;
    }
  }
}

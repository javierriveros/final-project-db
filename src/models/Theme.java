package models;

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
}

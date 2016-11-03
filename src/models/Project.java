package models;

import java.util.GregorianCalendar;

/**
 * Project Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Project {
  private int orderNumber;
  private GregorianCalendar startDate;

  public Project(int orderNumber, GregorianCalendar startDate) {
    this.orderNumber = orderNumber;
    this.startDate = startDate;
  }
  
  public int getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    if (orderNumber > 0) 
      throw new NumberFormatException("Order Number must be greater than zero");
    this.orderNumber = orderNumber;
  }

  public GregorianCalendar getStartDate() {
    return startDate;
  }

  public void setStartDate(GregorianCalendar startDate) {
    if(startDate == null) 
      throw new NullPointerException("Start Date can't be emtpy");
    this.startDate = startDate;
  }
  
  
}

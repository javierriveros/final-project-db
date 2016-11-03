package models;

/**
 * Inverstigation Group Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Group {
  private int id;
  private String name;
  private int componentsNumber;

  public Group(int id, String name, int componentsNumber) {
    this.id = id;
    this.name = name;
    this.componentsNumber = componentsNumber;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getComponentsNumber() {
    return componentsNumber;
  }

  public void setComponentsNumber(int componentsNumber) {
    this.componentsNumber = componentsNumber;
  }
  
  
}

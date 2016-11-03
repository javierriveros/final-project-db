package models;

/**
 * Tribunal Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Tribunal {
  private int id;
  private String testPlace;
  private int componentsNumber;

  public Tribunal(int id, String testPlace, int componentsNumber) {
    this.id = id;
    this.testPlace = testPlace;
    this.componentsNumber = componentsNumber;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTestPlace() {
    return testPlace;
  }

  public void setTestPlace(String testPlace) {
    this.testPlace = testPlace;
  }

  public int getComponentsNumber() {
    return componentsNumber;
  }

  public void setComponentsNumber(int componentsNumber) {
    this.componentsNumber = componentsNumber;
  }
  
  
}

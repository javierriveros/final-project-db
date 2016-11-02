package models;

/**
 * Tribunal Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Tribunal {
  private int id;
  private String test_place;
  private int componentsNumber;

  public Tribunal(int id, String test_place, int components_number) {
    this.id = id;
    this.test_place = test_place;
    this.componentsNumber = components_number;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTest_place() {
    return test_place;
  }

  public void setTest_place(String test_place) {
    this.test_place = test_place;
  }

  public int getComponentsNumber() {
    return componentsNumber;
  }

  public void setComponentsNumber(int componentsNumber) {
    this.componentsNumber = componentsNumber;
  }
  
  
}

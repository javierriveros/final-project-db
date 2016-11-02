package models;

/**
 * Teacher Model
 * @author Javier Riveros <walter.riveros@unillanos.edu.co>
 */
public class Teacher {
  private long ci;
  private String name;
  private String address;

  
  public Teacher() {}
  
  public Teacher(long ci, String name, String address) {
    this.ci = ci;
    this.name = name;
    this.address = address;
  }

  public long getCi() {
    return ci;
  }

  public void setCi(long ci) {
    this.ci = ci;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if(name == null || name.length() <= 0)
      throw new NullPointerException("Name can't be empty or null");
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
  
}

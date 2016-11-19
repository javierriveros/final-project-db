package controllers;

import java.sql.SQLException;
import java.util.LinkedList;
import models.Student;

public class StudentsController {
  public LinkedList<Student> index() throws SQLException {
    return Student.all();
  }
}

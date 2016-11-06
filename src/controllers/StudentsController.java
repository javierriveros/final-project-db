package controllers;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;

import models.Student;

public class StudentsController {
  public LinkedList<Student> index() {
    LinkedList<Student> students = new LinkedList<>();
    students.add(new Student(160003532, 2, "Walter Javier Riveros Castro", new Timestamp(1478226406)));
    students.add(new Student(160003546, 3, "Yamid Mauricio Leal Garcia", new Timestamp(1478226406)));
    return students;
  }
}

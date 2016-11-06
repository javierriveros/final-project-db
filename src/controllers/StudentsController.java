package controllers;

import java.sql.Date;
import java.util.LinkedList;

import models.Student;

public class StudentsController {
  public LinkedList<Student> index() {
    LinkedList<Student> students = new LinkedList<>();
    students.add(new Student(160003532, "Walter Javier Riveros Castro", new Date(1478226406)));
    students.add(new Student(160003546, "Yamid Mauricio Leal Garcia", new Date(1478226406)));
    return students;
  }
}

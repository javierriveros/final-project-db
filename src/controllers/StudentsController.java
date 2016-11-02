package controllers;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import models.Student;

public class StudentsController {
  public LinkedList<Student> index() {
    LinkedList<Student> students = new LinkedList<>();
    students.add(new Student(160003532, "Walter Javier Riveros Castro", new GregorianCalendar(0,1,1)));
    students.add(new Student(160003546, "Yamid Mauricio Leal Garcia", new GregorianCalendar(1,1,10)));
    return students;
  }
}

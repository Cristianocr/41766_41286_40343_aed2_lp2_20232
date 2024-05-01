package edu.ufp.inf.lp2._03_course;

import edu.ufp.inf.lp2.p01_intro.Date;

import java.util.ArrayList;
import java.util.Objects;

public class Grade {
    private float grade;

    private Date date;

    private Discipline discipline;

    private Student student;

    private ArrayList<Student> students;

    public Grade(float grade, Date date, Discipline discipline, Student student, ArrayList<Student> students) {
        this.grade = grade;
        this.date = date;
        this.discipline = discipline;
        this.student = student;
        this.students = students;
    }

    public Discipline associatedDiscipline() {
        return this.discipline;
    }

    public void associatedDiscipline(Discipline discipline) {

    }

    public Student associatedStudent() {
        return this.student;
    }

    public void associatedStudent(Student student) {
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return Float.compare(grade, grade1.grade) == 0 && Objects.equals(date, grade1.date) && Objects.equals(discipline, grade1.discipline) && Objects.equals(student, grade1.student) && Objects.equals(students, grade1.students);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Grade() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, date, discipline, student, students);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade=" + grade +
                ", date=" + date +
                ", discipline=" + discipline +
                ", student=" + student +
                ", students=" + students +
                '}';
    }
}

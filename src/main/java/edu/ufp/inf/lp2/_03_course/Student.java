package edu.ufp.inf.lp2._03_course;

import edu.ufp.inf.lp2.p01_intro.A;
import edu.ufp.inf.lp2.p01_intro.Date;
import edu.ufp.inf.lp2.p01_intro.Person;

import java.util.ArrayList;
import java.util.Objects;

public class Student extends Person {

    private ArrayList<Grade> grades = new ArrayList<>();

    private CourseClass course = new CourseClass();

    private long number;

    private Date registration;

    private String email;

    private String password;

    public Student(String idNumber, String name, String address, Date birth) {
        super(idNumber, name, address, birth);
    }

    public Student(String idNumber, String name, String address, Date birth, ArrayList<Grade> grades, CourseClass course, long number, Date registration, String email, String password) {
        super(idNumber, name, address, birth);
        this.grades = grades;
        this.course = course;
        this.number = number;
        this.registration = registration;
        this.email = email;
        this.password = password;
    }

    public void addGrade(Grade g) {

    }

    public Grade removeGrade(float g, String nd, Date d) {
        return null;
    }

    public Grade changeGrade(float ng, float g, String nd, Date d) {
        return null;
    }


    public Grade searchGrade(float g, String nd, Date d) {
        return null;
    }

    public float averageGrades() {
        return 0.0f;
    }

    public Grade maxGrade() {
        return null;
    }

    public Grade minGrade() {
        return null;
    }

    public void registerInCourseClass(CourseClass cc) {

    }

    public CourseClass unregisterInCourseClass() {
        return null;
    }


    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public CourseClass getCourse() {
        return course;
    }

    public void setCourse(CourseClass course) {
        this.course = course;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return number == student.number && Objects.equals(grades, student.grades) && Objects.equals(course, student.course) && Objects.equals(registration, student.registration) && Objects.equals(email, student.email) && Objects.equals(password, student.password);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grades, course, number, registration, email, password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "grades=" + grades +
                ", course=" + course +
                ", number=" + number +
                ", registration=" + registration +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

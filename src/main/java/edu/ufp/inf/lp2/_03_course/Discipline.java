package edu.ufp.inf.lp2._03_course;

import java.util.ArrayList;
import java.util.Objects;

public class Discipline {

    private ArrayList<Grade> grades = new ArrayList<Grade>();

    private CourseClass course = new CourseClass();

    private String name;

    private int ects;

    private short courseSemester;

    private short courseYear;

    public Discipline(ArrayList<Grade> grades, String name, int ects, short courseSemester, short courseYear) {
        this.grades = grades;
        this.name = name;
        this.ects = ects;
        this.courseSemester = courseSemester;
        this.courseYear = courseYear;
    }

    public void associateGrade(Grade g) {
        grades.add(g);
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public short getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(short courseSemester) {
        this.courseSemester = courseSemester;
    }

    public short getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(short courseYear) {
        this.courseYear = courseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return ects == that.ects && courseSemester == that.courseSemester && courseYear == that.courseYear && Objects.equals(grades, that.grades) && Objects.equals(name, that.name);
    }

    public Discipline() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(grades, name, ects, courseSemester, courseYear);
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "grades=" + grades +
                ", name='" + name + '\'' +
                ", ects=" + ects +
                ", courseSemester=" + courseSemester +
                ", courseYear=" + courseYear +
                '}';
    }

    public void setCourseClass(CourseClass courseClass) {
    }
}

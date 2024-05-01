package edu.ufp.inf.lp2._03_course;

import edu.ufp.inf.lp2.p01_intro.Date;

import java.util.ArrayList;
import java.util.Objects;

public class CourseClass {

    private ArrayList<Student> students = new ArrayList<Student>();

    private ArrayList<Discipline> disciplines = new ArrayList<Discipline>();

    private String name;

    public CourseClass(ArrayList<Student> students, ArrayList<Discipline> disciplines, String name) {
        this.students = students;
        this.disciplines = disciplines;
        this.name = name;
    }

    public ArrayList<Student> searchStudent(String name) {
        ArrayList<Student> resultArr = new ArrayList<>();
        for (Student s : students) {
            if (Objects.equals(s.getName(), name)) {
                resultArr.add(s);
            }
        }
        return resultArr;
    }

    public Student searchStudent(long number) {
        for (Student s : students) {
            if (Objects.equals(s.getNumber(), number)) {
                return s;
            }
        }
        return null;
    }

    public Discipline searchDiscipline(String name) {
        for (Discipline d : disciplines) {
            if (Objects.equals(d.getName(), name)) {
                return d;
            }
        }
        return null;
    }

    public void registerStudents(Student s) {
        students.add(s);
    }

    public Student unregisterStudents(String sname) {
        for (Student s : students) {
            if (Objects.equals(s.getName(), sname)) {
                return s;
            }
        }
        return null;
    }

    public void associateDiscipline(Discipline d) {
        if (!this.disciplines.contains(d)) {
            this.disciplines.add(d);
            d.setCourseClass(this);
        }
    }

    public Discipline desassociateDiscipline(String dname) {
        return searchDiscipline(dname);
    }

    public void launchGrade(String disciplineName, long studentNumber, float grade) {
        Student s = this.searchStudent(studentNumber);
        Discipline d = this.searchDiscipline(disciplineName);
        Date today = new Date(System.currentTimeMillis());
        Grade g = new Grade();
        g.setDate(today);
        g.associatedDiscipline(d);
        g.associatedStudent(s);
        s.addGrade(g);
        d.associateGrade(g);
    }

    public void associateGrade2Discipline(String disciplineName, long studentNumber, float grade) {
        Student s = this.searchStudent(studentNumber);
        Discipline d = this.searchDiscipline(disciplineName);

    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseClass that = (CourseClass) o;
        return Objects.equals(students, that.students) && Objects.equals(disciplines, that.disciplines) && Objects.equals(name, that.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public CourseClass() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, disciplines, name);
    }

    @Override
    public String toString() {
        return "CourseClass{" +
                "students=" + students +
                ", disciplines=" + disciplines +
                ", name='" + name + '\'' +
                '}';
    }
}

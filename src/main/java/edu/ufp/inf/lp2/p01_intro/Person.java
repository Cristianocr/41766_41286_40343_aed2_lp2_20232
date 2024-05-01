package edu.ufp.inf.lp2.p01_intro;

import java.time.LocalDate;

public class Person {

    private String idNumber;

    private String name;

    private String address;

    private Date birth;

    public Person(String idNumber, String name, String address, Date birth) {
        this.idNumber = idNumber;
        this.name = name;
        this.address = address;
        this.birth = birth;
    }

    public int age() {
        return 0;
    }

    public boolean olderThan(Person p) {
        return false;
    }

    public boolean equals(Object o) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}';
    }
}
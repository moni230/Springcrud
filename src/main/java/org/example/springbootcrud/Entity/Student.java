package org.example.springbootcrud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Student name is required")
    private String name;

    @NotBlank(message = "gender is required")
    private String gender;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "phone number is required")
    private String phoneNo;

    @NotBlank(message = "department is required")
    private String department;

//    @NotBlank(message = "CGPA is required")
    private double CGPA;


    public Student(int id, String name, String gender, String email, String phoneNo, String department, double CGPA) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phoneNo = phoneNo;
        this.department = department;
        this.CGPA = CGPA;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

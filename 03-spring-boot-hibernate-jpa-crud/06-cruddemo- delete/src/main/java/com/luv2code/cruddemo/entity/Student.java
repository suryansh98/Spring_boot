package com.luv2code.cruddemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    //define fields(columns)

    @Id //id says that this is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //it defines which algo to use for next key generation
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;



    //define constructors

    public Student() {

    }

    //Made New Constructor using (cmd + N) to generate

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



    //define getters/setters

    //Made New get/set using (cmd + N) to generate


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //define toString() Method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

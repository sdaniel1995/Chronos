package com.github.sdaniel;

public class Employee {
    private int eid;
    private String firstName;
    private String lastName;
    private String email;

    public Employee() {
        eid = -1;
        firstName = null;
        lastName = null;
        email = null;
    }

    public Employee(int eid, String firstName, String lastName, String email) {
        this.eid = eid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

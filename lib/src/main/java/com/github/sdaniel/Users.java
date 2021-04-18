package com.github.sdaniel;

public class Users {
    private int eid;
    private int mid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String position;

    public Users() {
        eid = -1;
        mid = -1;
        firstName = null;
        lastName = null;
        email = null;
        password = null;
        position = null;
    }
    
    public Users(int eid, int mid, String firstName, String lastName, String email, String password, String position) {
        this.eid = eid;
        this.mid = mid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.position = position;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    
    
}

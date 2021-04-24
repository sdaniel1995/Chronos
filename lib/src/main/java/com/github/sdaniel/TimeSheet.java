package com.github.sdaniel;

import java.sql.Date;

public class TimeSheet {
    private int id;
    private int eid;
    private Date submitDate;
    private double totalHours;
    private String status;
    

    public TimeSheet() {
        id = -1;
        id = -1;
        submitDate = null;
        totalHours = -1.0;
        status = "null";
    }

    public TimeSheet(int id, int eid, double totalHours, String status) {
        this.id = id;
        this.eid = eid;
        submitDate = new Date(System.currentTimeMillis());
        this.totalHours = totalHours;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}

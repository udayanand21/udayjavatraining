package com.coforge.models;

import java.time.LocalDate;

public class Employee {
    private long eid;
    private String eename;
    private double salary;
    private String email;
    private String mobile;
    private LocalDate doj;
    private LocalDate dob;

    public long getEid() { return eid; }
    public void setEid(long eid) { this.eid = eid; }

    public String getEename() { return eename; }
    public void setEename(String eename) { this.eename = eename; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public LocalDate getDoj() { return doj; }
    public void setDoj(LocalDate doj) { this.doj = doj; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
}

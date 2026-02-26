package com.coforge.assign2;

public class Student {
    private final String name;
    private final String id;
    private final int attendancePercent;

    public Student(String name, String id, int attendancePercent) {
        super();
        this.name = name;
        this.id = id;
        this.attendancePercent = attendancePercent;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public int getAttendancePercent() { return attendancePercent; }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + ", attendancePercent=" + attendancePercent + "]";
    }
}
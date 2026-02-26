package com.coforge.assign2;

public class UniRules {
    public static final String UniCode = "0474";
    public static final int MinAttendance = 75;
    public static int hallTicketCounter = 1000;

    public static String nextHallTicket(String examCode, String studentId) {
        return examCode + "-" + UniCode + "-" + studentId + "-" + (hallTicketCounter++);
    }
}
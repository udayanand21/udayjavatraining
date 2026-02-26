package com.coforge.assign2;

public class MidSemExam extends ExamProcess {

    public MidSemExam(String examCode) {
        super(examCode); // e.g., "MIDSEM"
    }

    @Override
    protected void conductExam(Student student, String hallTicket) {
        System.out.println("[Midterm] Hall " + hallTicket + ": Theory paper (2 hours).");
    }

    @Override
    protected int evaluate(Student student) {
        int base = Math.abs(student.getId().hashCode()) % 51 + 40; // 40..90
        int mcq = 8;
        return Math.min(base + mcq, 100);
    }
}
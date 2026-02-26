package com.coforge.assign2;

public final class Result {
    private final String examCode;
    private final Student student;
    private final int score;
    private final boolean passed;

    public Result(String examCode, Student student, int score, boolean passed) {
        this.examCode = examCode;
        this.student = student;
        this.score = score;
        this.passed = passed;
    }

    public String getExamCode() { return examCode; }
    public Student getStudent() { return student; }
    public int getScore() { return score; }
    public boolean isPassed() { return passed; }
}
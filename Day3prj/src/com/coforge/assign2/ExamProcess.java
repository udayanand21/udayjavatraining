package com.coforge.assign2;

public abstract class ExamProcess {

    public static final int PASS_MARKS = 40;
    protected final String examCode;

    protected ExamProcess(String examCode) {
        this.examCode = examCode;
    }

    public final Result run(Student student) {
        if (!validateEligibility(student)) {
            System.out.println(
                "Eligibility Check Failed for " + student.getName() +
                ": Attendance " + student.getAttendancePercent() + "% is below minimum " +
                UniRules.MinAttendance + "%"
            );
            return null;
        }

        String hallTicket = allocateHallTicket(student);
        conductExam(student, hallTicket);
        int score = evaluate(student);

        Result result = new Result(examCode, student, score, score >= PASS_MARKS);
        publishResult(result);
        return result;
    }

    protected boolean validateEligibility(Student student) {
        return student.getAttendancePercent() >= UniRules.MinAttendance;
    }

    protected String allocateHallTicket(Student student) {
        return UniRules.nextHallTicket(examCode, student.getId());
    }

    // NOTE: keep this signature consistent across subclasses
    protected abstract void conductExam(Student student, String hallTicket);
    protected abstract int evaluate(Student student);

    public final void publishResult(Result result) {
        System.out.println("=== Official University Result (" + UniRules.UniCode + ") ===");
        System.out.printf("Exam: %s | Student: %s (%s)%n",
                result.getExamCode(),
                result.getStudent().getName(),
                result.getStudent().getId());
        System.out.printf("Score: %d | Status: %s%n",
                result.getScore(),
                result.isPassed() ? "PASS" : "FAIL");
        System.out.println("============================================");
    }
}
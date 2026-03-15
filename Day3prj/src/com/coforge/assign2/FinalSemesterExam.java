package com.coforge.assign2;

public class FinalSemesterExam extends ExamProcess {
    private final int theory;     // 0..100
    private final int practical;  // 0..100

    public FinalSemesterExam(int theory, int practical) {
        super("FINALSEM");
        this.theory = theory;
        this.practical = practical;
    }

    @Override
    protected void conductExam(Student student, String hallTicket) {
        System.out.println("[Final Semester] Hall " + hallTicket + ": University theory + lab practical.");
    }

    @Override
    protected int evaluate(Student student) {
        double weighted = theory * 0.70 + practical * 0.30;
        int score = (int) Math.round(Math.max(0, Math.min(100, weighted)));
        return score;
    }
}
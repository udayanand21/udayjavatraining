package com.coforge.assign2;

public class LabPracticalExam extends ExamProcess {
    private final int codingScore; // 0..100
    private final int vivaScore;   // 0..100

    public LabPracticalExam(int codingScore, int vivaScore) {
        super("LABPRACT");
        this.codingScore = codingScore;
        this.vivaScore = vivaScore;
    }

    @Override
    protected void conductExam(Student student, String hallTicket) {
        System.out.println("[Lab Practical] Hall " + hallTicket + ": IDE setup, coding tasks, viva voce.");
    }

    @Override
    protected int evaluate(Student student) {
        double weighted = codingScore * 0.70 + vivaScore * 0.30;
        int score = (int) Math.round(Math.max(0, Math.min(100, weighted)));
        return score;
    }
}
package com.coforge.assign2;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("University Code: " + UniRules.UniCode);
        System.out.println("Min Attendance: " + UniRules.MinAttendance + "%");
        System.out.println("Pass Marks: " + ExamProcess.PASS_MARKS + "/100");

      
        Student s1 = new Student("Uday Anand", "S101", 82);  
        Student s2 = new Student("Asha Singh", "S102", 76);  
        Student s3 = new Student("Ravi Verma", "S103", 68);  

        
        ExamProcess midtermUday = new MidSemExam("MIDSEM");
        midtermUday.run(s1);

        ExamProcess labAsha = new LabPracticalExam(72, 20); 
        labAsha.run(s2);

   
        ExamProcess finalUday = new FinalSemesterExam(81, 70); 

    
        ExamProcess labRavi = new LabPracticalExam(90, 90);
        labRavi.run(s3);
    }
}
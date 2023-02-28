package org.example;
import java.util.logging.*;
import java.util.*;

class Student {
    static Logger l=Logger.getLogger("student.class");
    String sname;
    String sgrade;
    double sgpa;
    double gpoint;

    public Student(String name, String grade, double gpa) {
        sname = name;
        sgrade = grade;
        sgpa = gpa;
    }

    void updategpa() {
        Scanner s = new Scanner(System.in);
        l.info("Enter the total credits:");
        double credit = s.nextDouble();
        switch (sgrade) {
            case "A" -> gpoint = 5.00;
            case "B" -> gpoint = 4.00;
            case "C" -> gpoint = 3.00;
            case "D" -> gpoint = 2.00;
            case "E" -> gpoint = 1.00;
            default -> l.info("invalid choice");
        }
        sgpa = (credit * gpoint) / credit;
        l.log(Level.INFO,()->"The gpa value of the student is:"+ sgpa);
    }
    String display() {
        return sname + " has a " + sgpa + " GPA";
    }

    public static void main(String[] args) {
        Logger l=Logger.getLogger("student.class");
        Scanner s = new Scanner(System.in);
        String grade;
        l.info("Enter the student name:");
        String name = s.nextLine();
        l.info("Enter the student total mark:");
        int marks = s.nextInt();
        if (marks > 400) {
            grade = "A";
        } else if (marks > 300) {
            grade = "B";
        } else if (marks > 200) {
            grade = "C";
        } else if (marks > 100) {
            grade = "D";
        } else {
            grade = "E";
        }
        l.log(Level.INFO,()->"The grade of the student is:"+grade);
        Student st = new Student(name, grade, 0.0);
        st.updategpa();
        l.log(Level.INFO,()-> st.display());
    }
}

package ro.ase.acs.main;

import ro.ase.acs.classes.Student;
import ro.ase.acs.classes.TuitionType;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        float[] grades = {10, 8, 9};
        Student s2 = new Student("John Doe", grades);
        grades[0] = 5;

        s1.setTuitionType(TuitionType.TAX);
        s1.setGrades(grades);
        grades[0] = 7;

        float[] marks = s2.getGrades();
        marks[0] = 3;

        Student s3 = (Student) s2.clone();
        System.out.println(s3.getName());
    }
}

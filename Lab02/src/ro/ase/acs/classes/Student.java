package ro.ase.acs.classes;

import java.util.Arrays;

public class Student {
    private String name;
    private float[] grades;
    private TuitionType tuitionType;

    public Student() {
        name = "Anonymous";
        tuitionType = TuitionType.BUDGET;
    }

    public Student(String name, float[] grades) {
        this.name = name;
        if (grades != null) {
            this.grades = new float[grades.length];
            for (int i = 0; i < grades.length; i++) {
                this.grades[i] = grades[i];
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float[] getGrades() {
        if (grades != null) {
            float[] copy = new float[grades.length];
            System.arraycopy(grades, 0, copy, 0, grades.length);
            return copy;
        } else {
            return null;
        }
    }

    public void setGrades(float[] grades) {
        if (grades != null) {
            this.grades = Arrays.copyOf(grades, grades.length);
        } else {
            this.grades = null;
        }
    }

    public TuitionType getTuitionType() {
        return tuitionType;
    }

    public void setTuitionType(TuitionType tuitionType) {
        this.tuitionType = tuitionType;
    }

    @Override
    public Object clone() {
        Student copy = new Student();
        copy.name = name;
        copy.grades = getGrades();
        //copy.setGrades(grades);
        copy.tuitionType = tuitionType;

        return copy;
    }
}

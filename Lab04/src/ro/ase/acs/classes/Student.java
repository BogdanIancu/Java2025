package ro.ase.acs.classes;

public class Student {
    private String name;
    private float grade;

    public Student() {
    }

    public Student(String name, float grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

//    @Override
//    public String toString() {
//        return name + " " + grade;
//
//    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}

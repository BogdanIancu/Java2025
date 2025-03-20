package ro.ase.acs.main;

import ro.ase.acs.classes.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John", 9);
        Student s2 = new Student("Maria", 8);
        System.out.println(s1);
        System.out.println(eq("abc", "abc"));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        List<Student> studentList = new Vector<>();
        studentList.add(s1);
        studentList.add(s2);
        for (Student s : studentList) {
            s = new Student("abc", 0);
            System.out.println(s);
        }
        for (Iterator<Student> it = studentList.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        int x = 5;
        int y = 3;
        interchange(x, y);
        System.out.println(x + " " + y);
        Int a = new Int();
        a.value = 5;
        Int b = new Int();
        b.value = 3;
        interchange(a, b);
        System.out.println(a.value + " " + b.value);

    }

    public static <T> boolean eq(T value1, T value2) {
        return value1.equals(value2);
    }

    static class Int {
        public int value;
    }

//    public static void interchange(Int x, Int y) {
//        int aux = x.value;
//        x.value = y.value;
//        y.value = aux;
//    }

    public static void interchange(Int x, Int y) {
        Int aux = x;
        x = y;
        y = aux;
    }

    public static void interchange(int x, int y) {
        int aux = x;
        x = y;
        y = aux;

    }

}

package ro.ase.acs.main;

import ro.ase.acs.classes.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        Student s1 = new Student("John", 9);
        System.out.println(s1);
        Student s2 = new Student("John", 9);
        Student s3 = new Student("Maria", 10);
        Set<Student> set = new TreeSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println();
        for (Student s : set) {
            System.out.println(s);
        }

        set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println();
        for (Student s : set) {
            System.out.println(s);
        }

        Map<Integer, Student> map = new TreeMap<>();
        map.put(2, s1);
        map.put(3, s2);
        map.put(5, s3);

        System.out.println(map.get(5));

        for (int key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }

        Map<String, Student> hashMap = new HashMap<>();
        hashMap.put(s1.getName(), s1);
        hashMap.put(s3.getName(), s3);

        System.out.println(hashMap.get("Maria"));
    }
}

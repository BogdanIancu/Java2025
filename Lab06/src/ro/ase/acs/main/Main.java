package ro.ase.acs.main;

import ro.ase.acs.classes.Student;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("name=");
        String name = scanner.nextLine();

        System.out.print("age=");
        int age = scanner.nextInt();

        System.out.print("grade=");
        float grade = scanner.nextFloat();

        Student s1 = new Student(name, age, grade);
        System.out.println(s1);

        try {
            FileOutputStream fos = new FileOutputStream("student.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            writer.write(s1.getName());
            writer.newLine();

            writer.write(Integer.toString(s1.getAge()));
            writer.newLine();

            writer.write(Float.toString(s1.getGrade()));

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("student.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            String n = reader.readLine();
            int a = Integer.parseInt(reader.readLine());
            float g = Float.parseFloat(reader.readLine());

            Student s2 = new Student(n, a, g);
            System.out.println(s2);

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream fos;
        DataOutputStream os = null;

        try {
            fos = new FileOutputStream("Student.bin");

            os = new DataOutputStream(fos);

            os.writeUTF(s1.getName());
            os.writeInt(s1.getAge());
            os.writeFloat(s1.getGrade());

            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (FileInputStream fis = new FileInputStream("Student.bin");
             DataInputStream is = new DataInputStream(fis)) {

            String n = is.readUTF();
            int a = is.readInt();
            float g = is.readFloat();

            Student s3 = new Student(n, a, g);
            System.out.println(s3);

        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream outputStream = new FileOutputStream("Student.dat");
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(s1);

        FileInputStream inputStream = new FileInputStream("Student.dat");
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Student s4 = (Student) ois.readObject();
        System.out.println(s4);

        scanner.close();
    }
}

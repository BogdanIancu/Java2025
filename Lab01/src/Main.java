public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Student s1 = null;
        Student s2 = new Student();
        System.out.println(s2.getName());

        Student s3 = new Student("John", 9.5f);
        Student s4 = s3.myClone();
        s4.setName("George");
        System.out.println(s3.getName());
    }
}

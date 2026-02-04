class Student {
    int id;
    String name;
    int age;

    Student() {
        id = 0;
        name = "Unknown";
        age = 0;
    }

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Exp1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.display();

        System.out.println();

        Student s2 = new Student(101, "Akash", 19);
        s2.display();
    }
}


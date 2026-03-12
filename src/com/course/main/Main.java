package com.course.main;

import com.course.model.*;
import com.course.service.*;
import com.course.exception.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseService service = new CourseService();

        service.addCourse(new Course(101, "Java Programming", 2));
        service.addCourse(new Course(102, "Python Programming", 3));

        while (true) {

            System.out.println("\n1 Enroll Student");
            System.out.println("2 View Courses");
            System.out.println("3 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    try {

                        System.out.print("Enter Course ID: ");
                        int cid = sc.nextInt();

                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();

                        System.out.print("Enter Student Name: ");
                        String name = sc.next();

                        Student s = new Student(sid, name);

                        service.enrollStudent(cid, s);

                    } catch (CourseFullException |
                             CourseNotFoundException |
                             DuplicateEnrollmentException e) {

                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    service.viewCourses();
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}
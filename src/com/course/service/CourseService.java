package com.course.service;

import com.course.model.Course;
import com.course.model.Student;
import com.course.exception.*;

import java.util.*;
import java.io.*;

public class CourseService {

    private List<Course> courseList = new ArrayList<>();
    private final String FILE_NAME = "courses.txt";

    public void addCourse(Course c) {
        courseList.add(c);
        System.out.println("Course Added Successfully");
    }

    public void enrollStudent(int courseId, Student s)
            throws CourseFullException, CourseNotFoundException, DuplicateEnrollmentException {

        Course found = null;

        for (Course c : courseList) {
            if (c.getCourseId() == courseId) {
                found = c;
                break;
            }
        }

        if (found == null) {
            throw new CourseNotFoundException("Course not found");
        }

        if (found.getEnrolledStudents().size() >= found.getMaxSeats()) {
            throw new CourseFullException("Course is Full");
        }

        for (Student st : found.getEnrolledStudents()) {
            if (st.getStudentId() == s.getStudentId()) {
                throw new DuplicateEnrollmentException("Student already enrolled");
            }
        }

        found.getEnrolledStudents().add(s);

        saveToFile(found, s);

        System.out.println("Student Enrolled Successfully");
    }

    private void saveToFile(Course c, Student s) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(c.getCourseId() + "," +
                    c.getCourseName() + "," +
                    s.getStudentId() + "," +
                    s.getStudentName());

            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewCourses() {

        for (Course c : courseList) {
            c.displayCourse();
            System.out.println("--------------------");
        }

        System.out.println("Reading From File:");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File not found yet.");
        }
    }
}
import java.util.Scanner;
import java.util.InputMismatchException;

public class Evaluate {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.println("Enter Marks: ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks should be between 0 and 100");
            }

            if (marks >= 90){
                System.out.println("Student Name: " + name + ", Marks: " + marks + ", Grade: A");
            } else if (marks >= 75) {
                System.out.println("Student Name: " + name + ", Marks: " + marks + ", Grade: B");
            } else if (marks >= 60) {
                System.out.println("Student Name: " + name + ", Marks: " + marks + ", Grade: C");
            } else if (marks >= 40) {
                System.out.println("Student Name: " + name + ", Marks: " + marks + ", Grade: D");
            } else {
                System.out.println("Student Name: " + name + ", Marks: " + marks + ", Fail");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter numeric marks only!");
        }
    }
}

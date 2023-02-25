package Admission;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("\n\t\tWELCOME TO THE STUDENT ADMISSION PORTAL\n");
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter the number of students to enroll: ");
        int numberOfStudents = sc.nextInt();


        studentDatabase[] students = new studentDatabase[numberOfStudents];
        int studentNumber = 1;
        //creating n number of students
        for(int i = 0; i<numberOfStudents; i++){
            System.out.println("\nStudent No. "+ studentNumber++);
            students[i] = new studentDatabase();
        }
    }
}

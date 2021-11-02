package com.company;

import Models.Course;
import Models.Person;
import Models.Student;
import Models.Teacher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Student s1 = new Student(323211L, "a", "1");
        Student s2 = new Student(323211L, "b", "2");
        Student s3 = new Student(323211L, "c", "3");
        Student s4 = new Student(323211L, "d", "4");

        Teacher t1 = new Teacher(1L, "t", "1");
        Teacher t2 = new Teacher(2L, "u", "2");

        Course c1 = new Course(1L, "programming", t1, 2, 4);
        Course c2 = new Course(2L, "design", t2, 1, 3);

        boolean enrolled1 = s1.enrollInCourse(c1);
        if (!enrolled1) {
            System.out.println(String.format("We couldn't enroll %s", s1.toString()));
        }
        boolean enrolled2 = s2.enrollInCourse(c1);
        if (!enrolled2) {
            System.out.println(String.format("We couldn't enroll %s", s2.toString()));
        }
        boolean enrolled3 = s3.enrollInCourse(c1);
        if (!enrolled3) {
            System.out.println(String.format("We couldn't enroll %s", s3.toString()));
        }

//        String help = "r - register\nrc - retrieve course";
//        Scanner sc = new Scanner(System.in);
//        String command;
//
//        while (true) {
//            System.out.println("Write a command (input h for help)");
//            command = sc.next();
//            System.out.println(String.format("you entered the command %s", command));
//            switch (command) {
//                case "h":
//                    System.out.println(help);
//                    break;
//            }
//        }
    }
}

package com.edu.info.manager.controller;

import com.edu.info.manager.domain.Student;
import com.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {

    private Scanner sc = new Scanner(System.in);

    public Student inputStudentInfo(String id){
        System.out.println("請輸入學生姓名:");
        String name = sc.next();
        System.out.println("請輸入學生年齡:");
        int age = sc.nextInt();
        System.out.println("請輸入學生生日日期:");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}

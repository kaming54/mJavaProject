package com.edu.info.manager.controller;

import com.edu.info.manager.domain.Student;
import com.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {

    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        studentLoop:
        while (true) {
            System.out.println("------歡迎使用KM<學生>管理系統------");
            System.out.println("1.增加學生 2.刪除學生 3.更改學生 4.查詢學生 5.退出");
            System.out.println("請輸入你的選擇:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudentById();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    findAllStudent();
                    break;
                case 5:
                    System.out.println("謝謝使用學生管理系統,再見!");
                    break studentLoop;
                default:
                    System.out.println("資料有錯誤,請重新輸入!");
                    break;
            }
        }
    }

    public void addStudent(){
        String sid;
        while (true){
            System.out.println("請輸入學生編號:");
            sid = sc.next();
            boolean flag = studentService.isExists(sid);
            if(flag){
                System.out.println("學號已占用,請重新輸入");
            }else {
                break;
            }
        }
        Student stu = inputStudentInfo(sid);
        boolean result = studentService.addStudent(stu);
        if(result){
            System.out.println("增加成功");
        }else {
            System.out.println("增加失敗");
        }
    }

    public void findAllStudent() {
        Student[] arr = studentService.findAllStudent();
        if(arr==null){
            System.out.println("沒有任何資料");
            return;
        }
        System.out.println("學號\t\t姓名\t\t年齡\t\t生日");
        for (int i = 0; i < arr.length; i++) {
            Student stu = arr[i];
            if(stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());
            }
        }
    }

    public void deleteStudentById() {
        String delId = inputStudentId();
        studentService.deleteStudentById(delId);
        System.out.println("刪除成功");
    }

    public void updateStudent() {
        String updateId = inputStudentId();
        Student newStu = inputStudentInfo(updateId);
        System.out.println("更改成功");
        studentService.updateStudent(updateId,newStu);
    }

    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("請輸入學生編號:");
            id = sc.next();
            boolean exists = studentService.isExists(id);
            if (!exists) {
                System.out.println("你輸入的id不存在,請重新輸入:");
            } else {
                break;
            }
        }
        return id;
    }

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

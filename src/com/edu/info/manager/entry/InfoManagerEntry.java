package com.edu.info.manager.entry;

import com.edu.info.manager.controller.StudentController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------歡迎使用KM信息管理系統------");
            System.out.println("1.學生管理 2.老師管理 3.退出");
            System.out.println("請輸入你的選擇:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case 2:
                    System.out.println("老師管理");
                    break;
                case 3:
                    System.out.println("謝謝你的使用!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("資料有錯誤,請重新輸入!");
                    break;
            }
        }
    }
}

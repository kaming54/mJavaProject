package mStudentManager;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        loop:
        while (true){
            System.out.println("--------歡迎來到學生管理系統--------");
            System.out.println("1 增加學生");
            System.out.println("2 刪除學生");
            System.out.println("3 更改學生");
            System.out.println("4 查看所有學生");
            System.out.println("5 退出");
            System.out.println("請輸入你的選擇:");
            int inputNum = sc.nextInt();

            switch (inputNum){
                case 1:
                    addStudent(list);
                    break;
                case 2:
                    delStudent(list);
                    break;
                case 3:
                    updateStudent(list);
                    break;
                case 4:
                    getStudent(list);
                    break;
                case 5:
                    System.out.println("謝謝使用");
                    break loop;
                default:
                    System.out.println("輸入有錯誤,請重新輸入");
                    break;
            }
        }
    }

    public static int getIndex(ArrayList<Student> list, String sid){
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String dataId = stu.getSid();
            if(dataId.equals(sid)){
                index = i;
            }
        }
        return index;
    }

    public static void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true){
            System.out.println("請輸入學生編號:");
            sid = sc.next();
            int index = getIndex(list,sid);
            if(index == -1){
                break;
            }else{
                System.out.println("學生編號已存在,請重新輸入!");
            }
        }
        System.out.println("請輸入學生姓名:");
        String name = sc.next();
        System.out.println("請輸入學生年齡:");
        int age = sc.nextInt();
        System.out.println("請輸入學生生日日期:");
        String birthday = sc.next();

        Student stu = new Student(sid,name,age,birthday);
        list.add(stu);
        System.out.println("增加成功!");
    }

    public static void delStudent(ArrayList<Student> list){
        System.out.println("請輸入你需要刪除的學生編號:");
        Scanner sc = new Scanner(System.in);
        String delSid = sc.next();
        int index = getIndex(list,delSid);

        if(index == -1){
            System.out.println("該信息不存在,請重新輸入");
        }else {
            list.remove(index);
            System.out.println("刪除學生成功");
        }
    }

    private static void updateStudent(ArrayList<Student> list) {
        System.out.println("請輸入你需要更改的學生編號:");
        Scanner sc = new Scanner(System.in);
        String updateSid = sc.next();
        int index = getIndex(list,updateSid);

        if(index == -1){
            System.out.println("該信息不存在,請重新輸入");
        }else {
            System.out.println("請輸入學生新姓名:");
            String name = sc.next();
            System.out.println("請輸入學生新年齡:");
            int age = sc.nextInt();
            System.out.println("請輸入學生新生日日期:");
            String birthday = sc.next();
            Student stu = new Student(updateSid,name,age,birthday);
            list.set(index,stu);
            System.out.println("更改學生資料成功");
        }
    }

    public static void getStudent(ArrayList<Student> list){
        if(list.size()==0){
            System.out.println("資料庫沒有任何學生資料,請增加後再查詢!");
        }else {
            System.out.println("學號\t姓名\t年齡\t生日日期");
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());
            }
        }
    }

}
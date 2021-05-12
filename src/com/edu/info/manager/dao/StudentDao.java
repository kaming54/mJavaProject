package com.edu.info.manager.dao;

import com.edu.info.manager.domain.Student;


public class StudentDao {

    private static Student [] arr = new Student[5];

    public boolean addStudent(Student stu) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            Student students = arr[i];
            if(students == null){
                index = i;
                break;
            }
        }

        if(index == -1){
            return false;
        }else{
            arr[index] = stu;
            return true;
        }
    }

    public void updateStudent(String updateId, Student newStu) {
        int index = getIndex(updateId);
        arr[index] = newStu;
    }

    public Student[] findAllStudent() {
        return arr;
    }

    public void deleteStudentById(String delId) {
        int index = getIndex(delId);
        arr[index] = null;
    }

    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < arr.length ; i++) {
            Student stu = arr[i];
            if(stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }
}

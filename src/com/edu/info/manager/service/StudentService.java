package com.edu.info.manager.service;

import com.edu.info.manager.dao.StudentDao;
import com.edu.info.manager.domain.Student;

public class StudentService {

    private StudentDao studentDao = new StudentDao();

    public boolean addStudent(Student stu) {
        return studentDao.addStudent(stu);
    }

    public boolean isExists(String sid) {
        Student [] stuArr = studentDao.findAllStudent();
        boolean exists = false;
        for (int i = 0; i < stuArr.length; i++) {
            Student student = stuArr[i];
            //假設數組位置不是空和sid有相同
            if(student!=null && student.getId().equals(sid)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
        Student[] allStudent = studentDao.findAllStudent();

        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if(stu != null){
                flag = true;
                break;
            }
        }
        if(flag){
            return allStudent;
        }else {
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId,Student newStu) {
        studentDao.updateStudent(updateId,newStu);
    }
}

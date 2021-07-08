package com.ujiuye.service;

import com.ujiuye.bean.Students;
import com.ujiuye.dao.StudentDao;
import java.util.List;


public class StudentService {

    public boolean saveStudent(Students student) {
        if (student != null) {
            StudentDao ud = new StudentDao();
            int row = ud.saveStu(student);
            return row > 0 ? true : false;
        }
        return false;
    }

    public boolean selectAll() {
        StudentDao studentDao = new StudentDao();
        List<Students> students = studentDao.selectAll();
        if (students.size() != 0) {
            System.out.println("查询条数:" + students.size());
            System.out.println(students);
            return true;
        }
        return false;
    }

    public List<Students> selectLikeAll(String string) {

        StudentDao studentDao = new StudentDao();
        List<Students> list = studentDao.selectLikeAll(string);
        return  list;
    }
}

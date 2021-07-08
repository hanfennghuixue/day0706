package com.ujiuye.controller;


import com.ujiuye.bean.Students;
import com.ujiuye.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet("/reg")
public class AddStudentsServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取学生信息
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("Utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String sname = req.getParameter("sname");
        System.out.println("sname = " + sname);
        String gender = req.getParameter("gender");
        System.out.println("gender=" + gender);
        String hobby = req.getParameter("hobby");
        System.out.println("hobby = " + hobby);
        String degree = req.getParameter("degree");
        System.out.println("degree = " + degree);
        String mark = req.getParameter("mark");
        System.out.println("mark = " + mark);
        //性别获取到的为0.1转为int
        int gen = Integer.parseInt(gender.intern());
        //学生信息封装
        Students student = new Students(null, sname, gen, hobby, degree, mark);
        StudentService stud = new StudentService();
        boolean b = stud.saveStudent(student);
        System.out.println(student);
        if (b) {
            System.out.println("添加成功返回首页");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            System.out.println("注册失败,重新注册,返回注册页面");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        }
    }
}

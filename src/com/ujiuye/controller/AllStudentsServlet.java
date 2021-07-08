package com.ujiuye.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujiuye.bean.Students;
import com.ujiuye.dao.StudentDao;
import com.ujiuye.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class AllStudentsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean b = new StudentService().selectAll();
        if (b){
            System.out.println("查询成功!!!");
            List<Students> students = new StudentDao().selectAll();

            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(students);

            System.out.println("s = " + s);
            PrintWriter writer = resp.getWriter();
            writer.print(s);
            writer.close();


          /*
            req.setAttribute("list",students);
            System.out.println("将查询到的学生信息放入session中");*/

            req.getRequestDispatcher("showStudents.jsp").forward(req,resp);
        }else {
            System.out.println("查询失败!!");
        }

    }    }


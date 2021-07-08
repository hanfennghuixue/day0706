package com.ujiuye.dao;
import com.ujiuye.bean.Students;
import com.ujiuye.util.ThreadDruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class StudentDao {

    public int saveStu(Students student) {
        QueryRunner qr=new QueryRunner(ThreadDruidUtils.getDataSource());
        String sql="insert into Students values(null,?, ?, ?, ?, ? )";
        int row = 0;
        try {
            row = qr.update(sql, student.getSname(),student.getGender(),student.getHobby(),student.getDegree(),student.getMark());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public List<Students> selectAll(){
        QueryRunner qu = new QueryRunner(ThreadDruidUtils.getDataSource());
        String sql=" select *from Students ";

        List<Students> list = null;
        try {
            list = qu.query(sql, new BeanListHandler<>(Students.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;


    }

    /**
     * 根据名字模糊查询  %名称%
     * @param string
     * @return
     */
    public List<Students> selectLikeAll(String string){
        QueryRunner qr = new QueryRunner(ThreadDruidUtils.getDataSource());
        String sql="select *from students where  sname like '%"+string+"%'";
        List<Students> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Students.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

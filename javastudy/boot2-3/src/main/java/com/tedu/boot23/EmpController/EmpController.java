package com.tedu.boot23.EmpController;

import com.tedu.boot23.dao.EmpDao;
import com.tedu.boot23.entity.Emp;
import com.tedu.boot23.utils.DBUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@RestController
public class EmpController {
    @RequestMapping("/add")
    public String add(Emp emp, HttpServletResponse response) throws IOException {
        System.out.println("emp = " + emp);
        EmpDao dao =new EmpDao();
        dao.add(emp);
        return "添加成功!";
    }
    @RequestMapping(path = "/select",produces = "text/html;charset=utf-8")
    public String select(){
        String html="<table border='1'>";
        html+="<caption>员工列表</caption>";
        html+="<tr><th>id</th><th>名字</th><th>工资</th><th>工作</th><th>操作</th>";
        EmpDao dao=new EmpDao();
        ArrayList<Emp> list=dao.select();
        for (Emp e:list
             ) {
            html+="<tr>";
            html+="<td>"+e.getId()+"</td>";
            html+="<td>"+e.getName()+"</td>";
            html+="<td>"+e.getSal()+"</td>";
            html+="<td>"+e.getJob()+"</td>";
            html+="<td><a href='/delete?id="+e.getId()+"'>删除</td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;
    }
    @RequestMapping("/delete")
    public void delete(int id,HttpServletResponse response) throws IOException {
        System.out.println("id = " + id);
        EmpDao dao=new EmpDao();
        dao.deleteById(id);
        //重定向 给客户端响应了302状态码和路径
        response.sendRedirect("/select");
    }
    @RequestMapping("/update")
    public void update(Emp emp,HttpServletResponse response) throws IOException {
        System.out.println("emp = " + emp);
        EmpDao dao=new EmpDao();
        dao.update(emp);
        response.sendRedirect("/select");
    }
}

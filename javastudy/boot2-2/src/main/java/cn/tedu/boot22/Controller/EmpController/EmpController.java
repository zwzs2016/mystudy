package cn.tedu.boot22.Controller.EmpController;

import cn.tedu.boot22.entity.Emp;
import cn.tedu.boot22.utils.DBUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class EmpController {
    @RequestMapping("/add")
    public void add(Emp emp,HttpServletResponse response) throws IOException {
        System.out.println("emp = " + emp);
        try(Connection conn= DBUtils.getConn()) {
            String sql="insert into t_emp values(null,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,emp.getName());
            ps.setInt(2,emp.getSal());
            ps.setString(3,emp.getJob());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/select");
    }
    @RequestMapping(path = "/select",produces = "text/html;charset=utf-8")
    public String select(){
        String html="<table border='1'>";
        html+="<tr><th>id</th><th>名字</th><th>工资</th><th>工作</th><th>操作</th>";
        try(Connection conn= DBUtils.getConn()) {
            String sql="select `id`,`name`,`sal`,`job` from `t_emp`";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int sal=rs.getInt(3);
                String job=rs.getString(4);
                html+="<tr>";
                html+="<td>"+id+"</td>";
                html+="<td>"+name+"</td>";
                html+="<td>"+sal+"</td>";
                html+="<td>"+job+"</td>";
                html+="<td><a href='/delete?id="+id+"'>删除</td>";
                html+="</tr>";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        html+="</table>";
        return html;
    }
    @RequestMapping("/delete")
    public void delete(int id,HttpServletResponse response) throws IOException {
        System.out.println("id = " + id);
        try(Connection conn=DBUtils.getConn()) {
            String sql="delete from t_emp where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //重定向 给客户端响应了302状态码和路径
        response.sendRedirect("/select");
    }
    @RequestMapping("/update")
    public void update(Emp emp,HttpServletResponse response) throws IOException {
        System.out.println("emp = " + emp);
        try(Connection conn=DBUtils.getConn()) {
            String sql="update t_emp set `name`=?,`sal`=?,`job`=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,emp.getName());
            ps.setInt(2,emp.getSal());
            ps.setString(3,emp.getJob());
            ps.setInt(4,emp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/select");
    }
}

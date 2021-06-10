package com.tedu.boot23.dao;

import com.tedu.boot23.entity.Emp;
import com.tedu.boot23.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDao {

    public void add(Emp emp) {
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
    }

    public ArrayList<Emp> select() {
        ArrayList<Emp> list=new ArrayList<>();
        try(Connection conn= DBUtils.getConn()) {
            String sql="select `id`,`name`,`sal`,`job` from `t_emp`";
            Statement ps = conn.createStatement();
            ResultSet rs= ps.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int sal=rs.getInt(3);
                String job=rs.getString(4);
                Emp emp=new Emp(id,name,sal,job);
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(int id) {
        try(Connection conn=DBUtils.getConn()) {
            String sql="delete from t_emp where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Emp emp) {
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
    }
}

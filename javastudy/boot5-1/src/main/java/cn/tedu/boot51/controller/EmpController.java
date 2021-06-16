package cn.tedu.boot51.controller;

import cn.tedu.boot51.entity.Emp;
import cn.tedu.boot51.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired(required = false)
    EmpMapper mapper;

    @RequestMapping("/add")
    public void add(Emp emp){
        System.out.println("emp = " + emp);
        mapper.insert(emp);
    }
    @RequestMapping("/select")
    public List<Emp> select(){
        return mapper.selectAll();
    }
    @RequestMapping("/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }
    @RequestMapping("/selectById")
    public Emp selectById(int id){
        System.out.println("id = " + id);
        return mapper.selectById(id);
    }
    @RequestMapping("/update")
    public void update(@RequestBody Emp emp){
        System.out.println("emp = " + emp);
        mapper.update(emp);
    }

}

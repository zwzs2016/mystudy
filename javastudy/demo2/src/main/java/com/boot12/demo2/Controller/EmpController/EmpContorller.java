package com.boot12.demo2.Controller.EmpController;

import com.boot12.demo2.entity.Emp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpContorller {
    @RequestMapping("/add")
    public String emp(Emp emp){
        return "我叫"+emp.getName()+"今天"+emp.getAge()+"岁我的工作是"+emp.getJob();
    }
}

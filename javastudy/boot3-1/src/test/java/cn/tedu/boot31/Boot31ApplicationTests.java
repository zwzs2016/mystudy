package cn.tedu.boot31;

import cn.tedu.boot31.entity.Emp;
import cn.tedu.boot31.entity.Hero;
import cn.tedu.boot31.mapper.EmpMapper;
import cn.tedu.boot31.mapper.HeroMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Boot31ApplicationTests {
    //框架自动装配
    //由于EmpMapper是一个接口，不能new实例化
    @Autowired(required = false)
    EmpMapper mapper;
    @Autowired(required = false)
    HeroMapper heroMapper;
    @Test
    void contextLoads() {
        Emp emp=new Emp();
        emp.setName("孙尚香");
        emp.setSal(6888);
        emp.setJob("射手");
        mapper.insert(emp);
    }
    @Test
    void delete(){
        mapper.deleteById(6);
    }
    @Test
    void select(){
        mapper.selectAll();
    }
    @Test
    void update(){
        Emp emp=new Emp();
        emp.setId(8);
        emp.setName("程咬金");
        emp.setSal(8000);
        emp.setJob("战士");
        mapper.update(emp);
    }

    //hero
    @Test
    void insert() {
        Hero hero=new Hero(null,"李白","战士",10000);
        heroMapper.insert(hero);
    }
    @Test
    void deletehero(){
        heroMapper.deleteById(1);
    }
    @Test
    void selecthero(){
        List<Hero> heroes = heroMapper.selectAll();
        System.out.println(heroes);
    }
    @Test
    void updatehero(){
        Hero hero=new Hero(1,"李白","战士",2000);
        heroMapper.update(hero);
    }

}

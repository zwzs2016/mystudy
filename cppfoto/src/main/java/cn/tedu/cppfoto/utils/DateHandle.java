package cn.tedu.cppfoto.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateHandle {
    public boolean isToday(Date date){
        SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
        if(fmt.format(date).equals(fmt.format(new Date()))){//格式化为相同格式
            return true;
        }else {
            return false;
        }
    }
}

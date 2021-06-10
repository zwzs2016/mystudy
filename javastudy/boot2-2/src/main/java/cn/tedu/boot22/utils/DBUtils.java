package cn.tedu.boot22.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBUtils {
    private static DruidDataSource ds;

    static{
        Properties p = new Properties();
        InputStream ips = DBUtils.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        try {
            p.load(ips);//修改上面异常为最高级异常
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = p.getProperty("url");
        String username = p.getProperty("username");
        String password = p.getProperty("password");

        //创建数据库连接池
        ds = new DruidDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        //设置初始和最大数量
        ds.setInitialSize(3);
        ds.setMaxActive(5);
    }
    public static Connection getConn() throws Exception {

        return ds.getConnection();
    }
}

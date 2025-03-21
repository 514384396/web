package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//连接数据库
public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/cash?useSSL=false";
    private static final String USERNAME="root";
    private static final String PASSWORD="";

    private static volatile DataSource dataSource;

    //数据库连接池
    private static  DataSource getDataSource(){
        if(dataSource==null){
            synchronized (DBUtil.class){
                if(dataSource==null){
                    dataSource=new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }
    public static Connection getConnection(boolean autocommit){

        try{
            Connection connection=getDataSource().getConnection();
            connection.setAutoCommit(autocommit);
            return connection;
        }catch (SQLException e){
            e.printStackTrace();

        }
        return null;
    }
    public static void close(Connection cn, PreparedStatement ps, ResultSet rs){
        try{
            if(rs!=null) {
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(cn!=null){
                cn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        }
    }


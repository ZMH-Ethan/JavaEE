import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCinsert {
    public static void main(String[] args) throws SQLException {
        // JDBC 需要通过以下步骤来完成开发.
        // 1. 创建并初始化一个数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test_jdbc?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("20030603");
        // 2. 和数据库服务器建立连接.
        Connection connection = dataSource.getConnection();
        // 3. 构造 SQL 语句
        String sql = "insert into student value (1,'张三')";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 4. 执行 SQL 语句
        int ret = statement.executeUpdate();
        System.out.println("ret = " + ret);
        // 5. 释放必要的资源
        statement.close();
        connection.close();
    }
}

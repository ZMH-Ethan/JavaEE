import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCinsert2 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        // JDBC 需要通过以下步骤来完成开发.
        // 1. 创建并初始化一个数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test_jdbc?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("20030603");
        // 2. 和数据库服务器建立连接.
        Connection connection = dataSource.getConnection();
        // 3. 从控制台读取用户输入的内容
        System.out.println("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入学号：");
        int id = scanner.nextInt();
        // 4. 构造 SQL 语句
        String sql = "insert into student value (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        System.out.println(statement);
        // 5. 执行 SQL 语句
        int ret = statement.executeUpdate();
        System.out.println("ret = " + ret);
        // 6. 释放必要的资源
        statement.close();
        connection.close();
    }

}

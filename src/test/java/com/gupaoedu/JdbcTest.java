package com.gupaoedu;

import com.gupaoedu.domain.Blog;
import org.junit.Test;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qingshan
 */
public class JdbcTest {
    @Test
    public void testJdbc() throws IOException {
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();

        try {
            // 注册 JDBC 驱动
            // Class.forName("com.mysql.jdbc.Driver");

            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "test_h", "123456");

            // 执行查询
            stmt = conn.createStatement();
            String sql = "SELECT bid, name ,authorId FROM blog where bid <= 1010";
            ResultSet rs = stmt.executeQuery(sql);

            // 获取结果集
            List<Blog> list = new ArrayList<Blog>();
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("authorId");
                blog.setBid(bid);
                blog.setName(name);
                blog.setAuthorId(authorId);
                list.add(blog);
            }
            System.out.println(list);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    /**
     * 原生JDBC的批量操作方式 ps.addBatch()
     * @throws IOException
     */
    @Test
    public void testJdbcBatch() throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Long start = System.currentTimeMillis();
            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true", "test_h", "123456");
            ps = conn.prepareStatement(
                    "INSERT into blog values (?, ?, ?)");

            for (int i = 1000; i < 101000; i++) {
                Blog blog = new Blog();
                ps.setInt(1, i);
                ps.setString(2, String.valueOf(i)+"mybatis");
                ps.setInt(3, 1001);
                ps.addBatch();
            }

            ps.executeBatch();
            // conn.commit();
            ps.close();
            conn.close();
            Long end = System.currentTimeMillis();
            System.out.println("cost:"+(end -start ) +"ms");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

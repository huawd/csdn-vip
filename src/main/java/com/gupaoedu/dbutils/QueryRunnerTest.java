package com.gupaoedu.dbutils;

import com.gupaoedu.dbutils.dao.BlogDao;

/**
 * @Author: qingshan
 */
public class QueryRunnerTest {
    public static void main(String[] args) throws Exception {
        HikariUtil.init();
        System.out.println(BlogDao.selectBlog(1));
        // Language Level 设置成 Java 8
        BlogDao.selectList();
    }
}

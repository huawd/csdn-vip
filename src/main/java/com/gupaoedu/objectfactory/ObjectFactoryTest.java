package com.gupaoedu.objectfactory;

import com.gupaoedu.domain.Blog;

/**
 * @Author: qingshan
 */
public class ObjectFactoryTest {
    public static void main(String[] args) {
        GPObjectFactory factory = new GPObjectFactory();
        Blog myBlog = (Blog) factory.create(Blog.class);
        System.out.println(myBlog);
    }
}

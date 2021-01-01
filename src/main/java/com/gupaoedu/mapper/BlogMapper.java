package com.gupaoedu.mapper;

import com.gupaoedu.domain.BlogExample;
import com.gupaoedu.domain.associate.AuthorAndBlog;
import com.gupaoedu.domain.Blog;
import com.gupaoedu.domain.associate.BlogAndAuthor;
import com.gupaoedu.domain.associate.BlogAndComment;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Author: qingshan
 */
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);

    /**
     * 根据实体类查询文章
     * @param blog
     * @return
     */
    public List<Blog> selectBlogByBean(Blog blog);

    /**
     * 文章列表翻页查询
     * @param rowBounds
     * @return
     */
    public List<Blog> selectBlogList(RowBounds rowBounds);

    public List<Blog> selectBlogListIf(Blog blog);

    public List<Blog> selectBlogListChoose(Blog blog);

    public void deleteByList(List<Blog> list);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    public int updateByPrimaryKey(Blog blog);

    /**
     * 新增博客
     * @param blog
     * @return
     */
    public int insertBlog(Blog blog);

    /**
     * 批量插入博客
     * @param list
     * @return
     */
    public int insertBlogList(List<Blog> list);

    /**
     * 批量更新博客
     * @param list
     * @return
     */
    public int updateBlogList(List<Blog> list);

    /**
     * 根据博客查询作者，一对一，嵌套结果
     * @param bid
     * @return
     */
    public BlogAndAuthor selectBlogWithAuthorResult(Integer bid);

    /**
     * 根据博客查询作者，一对一，嵌套查询，存在N+1问题
     * @param bid
     * @return
     */
    public BlogAndAuthor selectBlogWithAuthorQuery(Integer bid);

    /**
     * 查询文章带出文章所有评论（一对多）
     * @param bid
     * @return
     */
    public BlogAndComment selectBlogWithCommentById(Integer bid);

    /**
     * 查询作者带出博客和评论（多对多）
     * @return
     */
    public List<AuthorAndBlog> selectAuthorWithBlog();

    List<Blog> selectByExample(BlogExample example);

}

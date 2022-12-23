package market.dao;

import market.model.Blog;

public interface BlogDao {

    Blog saveBlog(Blog blog);

    Blog findBlogById(Long id);
}

package market.service;

import market.model.Blog;

public interface BlogService {

    Blog saveBlog(Blog blog);

    Blog findBlogById(Long id);
}

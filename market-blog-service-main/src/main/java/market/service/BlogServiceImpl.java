package market.service;

import market.dao.BlogDao;
import market.model.Blog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogServiceImpl implements BlogService {

    final BlogDao blogDao;

    public BlogServiceImpl(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        return blogDao.saveBlog(blog);
    }

    @Override
    public Blog findBlogById(Long id) {
        return blogDao.findBlogById(id);
    }
}

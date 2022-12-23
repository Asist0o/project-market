package market.controller;

import market.model.Blog;
import market.service.BlogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public Blog findBlogById(@RequestParam Long id) {
        return blogService.findBlogById(id);
    }

    @PostMapping
    public Blog saveBlog(@RequestParam Blog blog) {
        return blogService.saveBlog(blog);
    }
}

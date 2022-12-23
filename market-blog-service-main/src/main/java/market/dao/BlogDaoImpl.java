package market.dao;

import market.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class BlogDaoImpl implements BlogDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Blog saveBlog(Blog blog) {
        em.persist(blog);
        return blog;
    }

    @Override
    public Blog findBlogById(Long id) {
        String query = """
                SELECT b
                FROM Blog b
                WHERE b.id = :id
                """;
        try {
            return em.createQuery(query, Blog.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }
}

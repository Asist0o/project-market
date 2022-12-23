package market.dao.Impl;

import market.dao.ExistDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ExistDaoImpl implements ExistDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean checkExistsEntity(Class entity, Long id) {

        String query =
                "SELECT COUNT (e.id) FROM " + entity.getSimpleName() +
                        " e WHERE e.id =:id";

        return em.createQuery(query, Long.class)
                .setParameter("id", id)
                .getSingleResult() > 0;
    }
}

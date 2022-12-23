package market.dao.Impl;

import market.dao.PageDtoDao;
import market.model.Advertisement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PageDtoDaoImpl<T> implements PageDtoDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long getTotalEntitiesCount() {
        Query query = entityManager.createQuery(
                """
                SELECT COUNT (a)
                FROM Advertisement a
                """
                );
        return (long) query.getSingleResult();
    }



    @Override
    public List<T> getEntitiesList(int currentPage, int countOnPage, String search) {
        Query query = entityManager.createQuery(
            """
            select a
            from Advertisement a
            left join fetch a.item as i
            left join fetch i.itemSubcategory as sub
            left join fetch i.sizeName
            left join fetch sub.sizeNameSet
            WHERE lower(a.description) LIKE lower(concat('%', :search, '%'))
            ORDER BY a.id DESC
            """);

        query.setParameter("search", search);
        query.setFirstResult((currentPage-1) * countOnPage);
        query.setMaxResults(countOnPage);

        return query.getResultList();
    }


    //заглушка
    @Override
    public long getInterestingEntitiesCount() {
        return 0;
    }
    //заглушка
    @Override
    public List<T> getInterestingList(int currentPage, int countOnPage) {
        return null;
    }
    //заглушка
    @Override
    public List<Advertisement> getAdvertismentWithPriority() {
        return null;
    }


}

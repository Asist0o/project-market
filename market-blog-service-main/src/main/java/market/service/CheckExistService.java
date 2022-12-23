package market.service;

import market.dao.ExistDao;
import org.springframework.stereotype.Service;

@Service
public record CheckExistService(ExistDao existDao) {

    public Boolean checkExistsEntity(Class entity, Long id) {
        return existDao.checkExistsEntity(entity, id);
    }
}

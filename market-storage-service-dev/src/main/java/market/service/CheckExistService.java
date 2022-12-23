package market.service;

import market.dao.ExistDao;
import org.springframework.stereotype.Service;

@Service
public class CheckExistService {

    private final ExistDao existDao;

    public CheckExistService(ExistDao existDao) {
        this.existDao = existDao;
    }

    public Boolean checkExistsEntity(Class entity, Long id) {
        return existDao.checkExistsEntity(entity, id);
    }
}

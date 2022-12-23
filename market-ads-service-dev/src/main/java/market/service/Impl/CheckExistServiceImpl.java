package market.service.Impl;

import market.dao.ExistDao;
import market.service.CheckExistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckExistServiceImpl implements CheckExistService {

    private final ExistDao existDao;

    @Autowired
    public CheckExistServiceImpl(ExistDao existDao) {
        this.existDao = existDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean checkExistsEntity(Class entity, Long id) {
        return existDao.checkExistsEntity(entity, id);
    }
}

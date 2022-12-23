package market.service.Impl;

import market.model.Advertisement;
import market.repository.AdvertisementRepository;
import market.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    @Override
    public Advertisement getById(long id) {
        return advertisementRepository.getAdvertisementById(id);
    }

    @Override
    public List<Advertisement> getByImportance(Boolean important) {
        return advertisementRepository.getAdvertisementsByImportant(important);
    }

    @Override
    public void save(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }

    @Override
    public void deleteById(long id) {
        advertisementRepository.deleteById(id);
    }
}

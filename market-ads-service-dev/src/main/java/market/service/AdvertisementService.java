package market.service;

import market.model.Advertisement;

import java.util.List;

public interface AdvertisementService {
    List<Advertisement> findAll();
    Advertisement getById(long id);
    List<Advertisement> getByImportance(Boolean isInterest);
    void save(Advertisement advertisement);
    void deleteById(long id);
}

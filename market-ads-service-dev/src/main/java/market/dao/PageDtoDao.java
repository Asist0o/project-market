package market.dao;

import market.model.Advertisement;

import java.util.List;

public interface PageDtoDao<T> {
    long getTotalEntitiesCount();
    long getInterestingEntitiesCount();
    List<T> getEntitiesList(int currentPage, int countOnPage, String search);
    List<T> getInterestingList(int currentPage, int countOnPage);

    List<Advertisement> getAdvertismentWithPriority();
}


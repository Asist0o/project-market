package market.Util.Sorting;

import market.model.Advertisement;

import java.util.Comparator;

public class SortingDateAdvertisment implements Comparator <Advertisement> {

    @Override
    public int compare(Advertisement date1, Advertisement date2) {
        return date2.getCreateDate().compareTo(date1.getCreateDate());
    }
}

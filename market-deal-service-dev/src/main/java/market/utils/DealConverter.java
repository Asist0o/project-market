package market.utils;

import market.dto.DealDto;
import market.model.Deal;

public class DealConverter {
    public static Deal toEntity(DealDto dealDto) {
        Deal deal = new Deal();
        deal.setId(dealDto.getId());
        deal.setIdProducer(dealDto.getIdProducer());
        deal.setIdConsumer(dealDto.getIdConsumer());
        deal.setIdAdvertisement(dealDto.getIdAdvertisement());
        deal.setPrice(dealDto.getPrice());
        deal.setTypeDeal(dealDto.getTypeDeal());
        deal.setStatusDeal(dealDto.getStatusDeal());
        return deal;
    }
}

package market.service;

import market.dto.DealDto;
import market.model.Deal;

import java.util.List;

public interface DealService {
    boolean checkExist(DealDto dealDto);

    List<Deal> getAll();
}

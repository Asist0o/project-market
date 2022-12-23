package market.service.impl;


import lombok.AllArgsConstructor;
import market.dto.DealDto;
import market.model.Deal;
import market.repository.DealRepository;
import market.service.DealService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;


    @Override
    public boolean checkExist(DealDto dealDto) {
        return dealRepository.existsById(dealDto.getId());
    }

    @Override
    public List<Deal> getAll() {
        return dealRepository.findAll();
    }
}

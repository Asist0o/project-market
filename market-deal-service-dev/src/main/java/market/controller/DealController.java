package market.controller;

import lombok.AllArgsConstructor;
import market.dto.DealDto;
import market.model.Deal;
import market.response.Response;
import market.service.DealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/deal")
public class DealController {

    private final DealService dealService;

    @GetMapping
    public List<Deal> getAll() {
        return dealService.getAll();
    }

    @PostMapping
    public Response<?> add(@RequestBody DealDto dealDto) {
        return Response.success().status(dealService.checkExist(dealDto) ? 200 : 404).build();
    }
}

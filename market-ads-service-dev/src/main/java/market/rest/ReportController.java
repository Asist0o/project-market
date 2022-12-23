package market.rest;

import market.model.Report;
import market.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private ReportService service;

    @Autowired
    private ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Report> getPaginated(@RequestParam(required = false, defaultValue = "0") int pageNumber,
                                     @RequestParam(required = false, defaultValue = "10") int pageSize,
                                     @RequestParam(required = false, defaultValue = "") String search) {
        if (!search.isEmpty()){
            return service.findAllByMessageContaining(search, pageNumber, pageSize);
        } else {
            return service.findAll(pageNumber, pageSize);
        }
    }
}

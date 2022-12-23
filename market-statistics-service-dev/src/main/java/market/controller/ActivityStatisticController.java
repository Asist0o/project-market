package market.controller;

import market.dto.ActivityByRageDate;
import market.service.ActivityStatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@RestController
@RequestMapping("/api/activity")
public class ActivityStatisticController {

    private final ActivityStatisticService activityService;

    public ActivityStatisticController(ActivityStatisticService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public Set<ActivityByRageDate> getEntryCountByRageDate(@RequestParam(name = "startDate", required = false) String startDate,
                                                           @RequestParam(name = "endDate", required = false) String endDate) {
        return activityService.getEntryCountByRageDate(startDate, endDate);
    }
}

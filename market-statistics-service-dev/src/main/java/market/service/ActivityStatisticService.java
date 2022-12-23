package market.service;

import market.data.UserActivityRepository;
import market.dto.ActivityByRageDate;
import market.dto.UserActivity;
import market.dto.VisitHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ActivityStatisticService {
    private final UserActivityRepository userTrafficRepo;

    public ActivityStatisticService(UserActivityRepository userTrafficRepo) {
        this.userTrafficRepo = userTrafficRepo;
    }

    public Set<ActivityByRageDate> getEntryCountByRageDate(String startDate, String endDate) {
        Iterable<UserActivity> userActivities = userTrafficRepo.findAll();
        Map<LocalDateTime, Integer> mapCountByDate = StreamSupport.stream(userActivities.spliterator(), false)
                .map(UserActivity::getVisitHistory)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.groupingBy(
                                VisitHistory::getReportDate,
                                Collectors.summingInt(VisitHistory::getShowingCount)
                        )
                );

        LocalDateTime startDateTimeFromString = convertStringByLocalDateTime(startDate, LocalDateTime.MIN.toLocalTime());
        LocalDateTime endDateTimeFromString = convertStringByLocalDateTime(endDate, LocalDateTime.MAX.toLocalTime());

        return mapCountByDate.entrySet().stream()
                .filter(e -> (startDateTimeFromString.isEqual(e.getKey())
                        || endDateTimeFromString.isEqual(e.getKey())
                        || startDateTimeFromString.isBefore(e.getKey())
                        && endDateTimeFromString.isAfter(e.getKey())))
                .map(e -> new ActivityByRageDate(e.getKey(), e.getValue()))
                .collect(Collectors.toSet());
    }

    private LocalDateTime convertStringByLocalDateTime(String date, LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        return LocalDateTime.of(LocalDate.parse(date, formatter), time);
    }
}

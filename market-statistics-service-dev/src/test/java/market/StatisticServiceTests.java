package market;

import market.controller.ActivityStatisticController;
import market.dto.UserActivity;
import market.dto.VisitHistory;
import market.service.AccountStatisticService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StatisticServiceTests {
    private Long tempId = 0L;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ActivityStatisticController activityStatisticController;

    @Autowired
    private AccountStatisticService accountStatisticService;

    @Test
    public void statisticControllerTest() {
        assertThat(activityStatisticController).isNotNull();
    }

    @Test
    public void activityStatisticTest() throws Exception {
        String stringDate = "2021-10-10";
        UserActivity user = new UserActivity();
        addNewUserActivity(user);
        addNewVisit(stringDate, user);

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        String stringStartDate = "2022-01-02";
        String stringEndDate = "2022-05-05";
        requestParams.add("startDate", stringStartDate);
        requestParams.add("endDate", stringEndDate);

        this.mockMvc.perform(get("/api/activity").params(requestParams))
                .andDo(print())
                .andExpect(status().isOk());
    }


    private void addNewUserActivity(UserActivity user) {
        user.setAccountId(tempId++);
        accountStatisticService.saveActivity(user);
    }

    private void addNewVisit(String dateActivity, UserActivity user){
        VisitHistory visitHistory = new VisitHistory();
        Set<VisitHistory> set = new HashSet<>();

        LocalDateTime dateTimeFromString = convertStringByLocalDateTime(dateActivity);

        user.setLastVisitDate(dateTimeFromString);
        visitHistory.setReportDate(dateTimeFromString);
        visitHistory.setShowingCount(4);
        set.add(visitHistory);
        user.setVisitHistory(set);
    }

    private LocalDateTime convertStringByLocalDateTime (String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        return LocalDateTime.of(LocalDate.parse(date, formatter),
                LocalDateTime.MIN.toLocalTime());
    }
}

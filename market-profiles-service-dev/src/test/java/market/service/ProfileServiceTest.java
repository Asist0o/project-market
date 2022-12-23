package market.service;

import market.ProfilesStarter;
import market.entity.Feedback;
import market.entity.Profile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProfilesStarter.class})
public class ProfileServiceTest {

    @Autowired
    ProfileService profileService;

    @Test
    public void add(){
        Feedback feedback1 = new Feedback();
        feedback1.setScore(1.5f);
        feedback1.setDescription("feedback1");
        Feedback feedback2 = new Feedback();
        feedback2.setScore(2.5f);
        feedback2.setDescription("feedback2");
        Set<Feedback> feedbacks = new HashSet<>();
        feedbacks.add(feedback1);
        feedbacks.add(feedback2);

        Profile profile = new Profile();
        profile.setAccountId(100L);
        profile.setBirthday(LocalDate.of(1969, Month.APRIL, 2));
        profile.setRegistrationDate(LocalDateTime.now());
        profile.setEmail("test1@mail.ru");
        profile.setCity("NightCity");
        profile.setFirstName("alex");
        profile.setLastName("alex");
        profile.setFeedbacks(feedbacks);
        profileService.saveProfile(profile);
    }
}


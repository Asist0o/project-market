package market.entity;

import market.repository.ProfileRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProfileTest {
    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void saveProfile(){

        Set<Feedback> feedbacks = new HashSet<>();
        feedbacks.add(new Feedback("feedback",2.5f));
        Profile profile = new Profile();
        profile.setBirthday(LocalDate.of(1969, Month.APRIL, 2));
        profile.setRegistrationDate(LocalDateTime.now());
        profile.setEmail("test3@mail.ru");
        profile.setCity("City");
        profile.setFirstName("Mark");
        profile.setLastName("Carl");
        profile.setFeedbacks(feedbacks);
        profileRepository.save(profile);

        Assert.assertNotNull(profileRepository.findByEmail("test3@mail.ru"));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void saveProfileEmptyEmail(){

        Set<Feedback> feedbacks = new HashSet<>();
        feedbacks.add(new Feedback("feedback",2.5f));
        Profile profile = new Profile();
        profile.setAccountId(2L);
        profile.setBirthday(LocalDate.of(1969, Month.APRIL, 2));
        profile.setRegistrationDate(LocalDateTime.now());
        profile.setCity("City");
        profile.setFirstName("Mark");
        profile.setLastName("Carl");
        profile.setFeedbacks(feedbacks);

        profileRepository.save(profile);
    }
}


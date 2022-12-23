package market.service;

import market.entity.Feedback;
import market.entity.Profile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProfileJpatest {

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void add(){
        try {
            Feedback feedback = entityManager.find(Feedback.class, 1L);
            Set<Feedback> feedbacks = new HashSet<>();
            feedbacks.add(feedback);
            Profile profile = new Profile();
            profile.setAccountId(302L);
            profile.setBirthday(LocalDate.of(1969, Month.APRIL, 2));
            profile.setRegistrationDate(LocalDateTime.now());
            profile.setEmail("test3@mail.ru");
            profile.setCity("City");
            profile.setFirstName("Mark");
            profile.setLastName("Carl");
            profile.setFeedbacks(feedbacks);
            entityManager.persist(profile);
        }catch(Exception e){
            Assert.fail("при тестировании добавления профиля призошло исключение \n"+e);
        }
    }
}

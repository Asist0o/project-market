package market.service;

import market.data.UserActivityRepository;
import market.dto.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountStatisticService {
    private final UserActivityRepository userTrafficRepo;

    @Autowired
    public AccountStatisticService(UserActivityRepository userTrafficRepo) {
        this.userTrafficRepo = userTrafficRepo;
    }

    public void saveActivity(UserActivity userActivity) {
        userTrafficRepo.save(userActivity);
    }

    @Transactional(readOnly = true)
    public Iterable<UserActivity> findAllActivity() {
        return userTrafficRepo.findAll();
    }
}

package market.service;

import market.entity.Profile;
import market.feign.ProfileFeignClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

@EnableScheduling
public class ScheduledService {

    private final ProfileService profileService;
    private final ProfileFeignClient profileFeignClient;

    public ScheduledService(ProfileService profileService, ProfileFeignClient profileFeignClient) {
        this.profileService = profileService;
        this.profileFeignClient = profileFeignClient;
    }

    @Scheduled (cron = "0 5 * * *")
    public void birthdayCheck() {
        Profile profile = profileService.findByBirthday(LocalDate.now());

        if (profile != null) {
            profileFeignClient.sendBirthdayMessage(profile.getEmail(), profile.getEmail());
        }
    }
}

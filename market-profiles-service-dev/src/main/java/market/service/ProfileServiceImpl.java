package market.service;

import market.entity.Profile;
import market.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileServiceImpl.class);

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findProfileByEmail(String email) {
        LOGGER.info("RequestParam:" + email);
        return profileRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public Profile saveProfile(Profile profile) {
        LOGGER.info("Request body: " + profile.toString());
        return profileRepository.save(profile);
    }

    @Transactional
    @Override
    public Profile updateProfile(Profile profile) {
        LOGGER.info("Request body: " + profile.toString());
        return profileRepository.save(profile);
    }

    @Override
    public Profile findProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public Profile findByBirthday(LocalDate localDate) {
        return profileRepository.findByBirthday(localDate);
    }
}

package market.service;

import market.entity.Profile;

import java.time.LocalDate;

public interface ProfileService {
    Profile findProfileByEmail(String email);

    Profile saveProfile(Profile profile);

    Profile updateProfile(Profile profile);

    Profile findProfileById(Long id);

    Profile findByBirthday(LocalDate localDate);
}

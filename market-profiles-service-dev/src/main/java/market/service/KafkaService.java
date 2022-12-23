package market.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import market.dto.ProfileCreatedEventDto;
import market.entity.Profile;
import market.repository.ProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;

    public void persistProfile(ProfileCreatedEventDto profileCreatedEventDto) {
        Profile profile = modelMapper.map(profileCreatedEventDto, Profile.class);
        Profile persistProfile = profileRepository.save(profile);
        log.info("profileCreatedEvent persisted {}", persistProfile);
    }
}

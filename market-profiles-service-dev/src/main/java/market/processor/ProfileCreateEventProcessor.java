package market.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import market.dto.ProfileCreatedEventDto;
import market.entity.Profile;
import market.service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProfileCreateEventProcessor implements Consumer<Message<ProfileCreatedEventDto>> {

    private final ProfileService profileService;
    private final ModelMapper modelMapper;

    @Override
    public void accept(Message<ProfileCreatedEventDto> profileCreatedEventDtoMessage) {
        Profile profile = modelMapper.map(profileCreatedEventDtoMessage.getPayload(), Profile.class);
        Profile persistProfile = profileService.saveProfile(profile);
        log.info("profileCreatedEvent persisted {}", persistProfile);
    }


}

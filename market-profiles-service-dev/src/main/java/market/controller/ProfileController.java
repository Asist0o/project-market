package market.controller;


import market.dto.ProfileDto;
import market.entity.Profile;
import market.service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO @Константин
// общий маппинг /api/profiles
// сделать ДТО и не принимать целую сущность
// респонсы везде
// ПАГИНАЦИЯ ДЛЯ ПРОФИЛЕЙ ТУТ

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProfileController(ProfileService profileService, ModelMapper modelMapper) {
        this.profileService = profileService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/email")
    public ResponseEntity<ProfileDto> findProfileByEmail(@RequestParam String email) {
        Profile profile = profileService.findProfileByEmail(email);
        if(profile == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        ProfileDto profileDto = modelMapper.map(profile, ProfileDto.class);
        return new ResponseEntity<>(profileDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProfileDto> saveProfile(@RequestBody ProfileDto profileDto) {
        Profile profile = modelMapper.map(profileDto, Profile.class);
        profileService.saveProfile(profile);
        profileDto = modelMapper.map(profile, ProfileDto.class);
        return new ResponseEntity<>(profileDto, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> findProfileById(@PathVariable Long id) {
        Profile profile = profileService.findProfileById(id);
        if(profile == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        ProfileDto profileDto = modelMapper.map(profile, ProfileDto.class);
        return new ResponseEntity<>(profileDto, HttpStatus.OK);
    }
}

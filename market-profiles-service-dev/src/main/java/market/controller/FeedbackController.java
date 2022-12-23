package market.controller;

import market.dto.FeedbackDto;
import market.entity.Feedback;
import market.entity.Profile;
import market.response.Response;
import market.service.FeedbackService;
import market.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final ProfileService profileService;
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(ProfileService profileService, FeedbackService feedbackService) {
        this.profileService = profileService;
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public Set<Feedback> findFeedbackByIdProfile(@RequestParam Long profileId){
        return profileService.findProfileById(profileId).getFeedbacks();
    }
    @PutMapping
    public Response updateFeedbackById(@RequestBody Feedback feedback){
        feedbackService.updateFeedback(feedback);
        return Response.success().status(200).build();
    }
    @PostMapping
    public Response addFeedback(@RequestBody @Valid FeedbackDto feedbackDto, @RequestParam Long profileId) {
        Profile profile = profileService.findProfileById(profileId);
        profile.setFeedbacks(feedbackDto);
        profileService.updateProfile(profile);
        return Response.success().status(200).build();
    }

    @DeleteMapping("/{id}")
    public Response deleteFeedback(@PathVariable Long id){
        feedbackService.deleteFeedbackByID(id);
        return Response.success().status(200).build();
    }
}

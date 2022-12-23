package market.service;

import market.entity.Feedback;
import market.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    @Transactional
    public void deleteFeedbackByID(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
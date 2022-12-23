package market.service;

import market.entity.Feedback;

public interface FeedbackService {
    void deleteFeedbackByID(Long id);
    void updateFeedback(Feedback feedback);
}

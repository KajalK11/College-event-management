package com.collegeevent.KajalK11.College_event_management.service;

import com.collegeevent.KajalK11.College_event_management.model.Feedback;
import com.collegeevent.KajalK11.College_event_management.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class FeedbackService {
    public Feedback createFeedback(Feedback feedback) {
        return null;
    }package com.collegeevent.KajalK11.College_event_management.service;

import com.collegeevent.KajalK11.College_event_management.model.Feedback;
import com.collegeevent.KajalK11.College_event_management.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class FeedbackService {

        @Autowired
        private FeedbackRepository feedbackRepository;

        public Feedback createFeedback(Feedback feedback) {
            return feedbackRepository.save(feedback);
        }

        public List<Feedback> getAllFeedbacks() {
            return feedbackRepository.findAll();
        }

        public Feedback getFeedbackById(Long id) {
            return feedbackRepository.findById(id).orElse(null);
        }

        public Feedback updateFeedback(Long id, Feedback feedbackDetails) {
            Feedback feedback = getFeedbackById(id);
            if (feedback != null) {
                feedback.setEventId(feedbackDetails.getEventId());
                feedback.setUserId(feedbackDetails.getUserId());
                feedback.setMessage(feedbackDetails.getMessage());
                feedback.setRating(feedbackDetails.getRating());
                return feedbackRepository.save(feedback);
            }
            return null;
        }

        public boolean deleteFeedback(Long id) {
            if (feedbackRepository.existsById(id)) {
                feedbackRepository.deleteById(id);
                return true;
            }
            return false;
        }

        public List<Feedback> getFeedbacksByEventId(Long eventId) {
            return feedbackRepository.findByEventId(eventId);
        }

        public List<Feedback> getFeedbacksByUserId(Long userId) {
            return feedbackRepository.findByUserId(userId);
        }
    }
}

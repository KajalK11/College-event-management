package com.collegeevent.KajalK11.College_event_management.repository;

import com.collegeevent.KajalK11.College_event_management.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class FeedbackRepository { package com.collegeevent.KajalK11.College_event_management.repository;

import com.collegeevent.KajalK11.College_event_management.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
        List<Feedback> findByEventId(Long eventId);
        List<Feedback> findByUserId(Long userId);
    }
}

package com.collegeevent.KajalK11.College_event_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Event ID is required")
    @Column(nullable = false)
    private Long eventId;

    @NotNull(message = "User ID is required")
    @Column(nullable = false)
    private Long userId;

    @Size(max = 500, message = "Message must be less than 500 characters")
    private String message;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    @Column(nullable = false)
    private int rating;

    // Constructors
    public Feedback() {
    }

    public Feedback(Long eventId, Long userId, String message, int rating) {
        this.eventId = eventId;
        this.userId = userId;
        this.message = message;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return rating == feedback.rating &&
                Objects.equals(id, feedback.id) &&
                Objects.equals(eventId, feedback.eventId) &&
                Objects.equals(userId, feedback.userId) &&
                Objects.equals(message, feedback.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventId, userId, message, rating);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                ", rating=" + rating +
                '}';
    }
}
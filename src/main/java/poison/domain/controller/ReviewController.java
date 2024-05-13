package poison.domain.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import poison.domain.entity.User;
import poison.domain.entity.Review;
import poison.domain.repository.ReviewRepository;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @GetMapping("/api/review")
    public ResponseEntity<?> getReview() {
        Review review = reviewRepository.findById("--03GwblmsiubcsmY4qVLw").orElseThrow(EntityNotFoundException::new);
        User user = review.getUser();
        return ResponseEntity.ok(user);
    }
}

package poison.controller;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import poison.entity.Review;
import poison.entity.User;
import poison.repository.ReviewRepository;
import poison.repository.UserRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping("/api/user")
    public ResponseEntity<?> getBusiness() {
        List<String> overTenReviewUser = userRepository.findOverTenReviewUser();
        List<Review> reviewList = reviewRepository.findByUserList(overTenReviewUser);

        return ResponseEntity.ok(overTenReviewUser);
    }
}

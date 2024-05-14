package poison.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import poison.domain.review.entity.Review;
import poison.domain.review.repository.ReviewRepository;
import poison.domain.user.repository.UserRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping("/api/user")
    public ResponseEntity<?> getBusiness() {
        long a = userRepository.countOverTenReviewUserWithJoin();
//        List<Review> reviewList = reviewRepository.findByUserList(overTenReviewUser);

        return ResponseEntity.ok(a);
    }
}

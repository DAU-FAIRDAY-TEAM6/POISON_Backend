package poison.domain.review.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import poison.domain.user.dto.UserResponse;
import poison.domain.user.entity.User;
import poison.domain.review.entity.Review;
import poison.domain.review.repository.ReviewRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @GetMapping("/api/review")
    public ResponseEntity<?> getReview() {
        Review review = reviewRepository.findById("--03GwblmsiubcsmY4qVLw").orElseThrow(EntityNotFoundException::new);
        User user = review.getUser();
        return ResponseEntity.ok(UserResponse.from(user));
    }

    @GetMapping("/api/review/philadelphia-cnt")
    public ResponseEntity<?> cntPhiladelphia() {
        long startTime = System.currentTimeMillis(); // 시작 시간 기록


        List<Review> reviewList = reviewRepository.countPhiladelphiaReview();
        log.info("=====================");
        // 사용자별 리뷰 수를 카운팅
        Map<String, Long> userReviewCount = reviewList.stream()
                .collect(Collectors.groupingBy(review -> review.getUser().getId(), Collectors.counting()));

        // 10개 이상 리뷰를 작성한 사용자만 필터링
        List<String> usersWithMoreThanTenReviews = userReviewCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= 10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis(); // 종료 시간 기록
        long executionTime = endTime - startTime; // 수행 시간 계산
        log.info("Execution time: {} ms", executionTime); // 로그로 수행 시간 출력

        return ResponseEntity.ok(usersWithMoreThanTenReviews);
    }
}

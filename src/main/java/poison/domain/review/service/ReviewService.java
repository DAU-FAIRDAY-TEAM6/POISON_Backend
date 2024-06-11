package poison.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poison.domain.review.dto.ReviewResponse;
import poison.domain.review.entity.Review;
import poison.domain.review.repository.ReviewRepository;
import poison.domain.user.entity.User;
import poison.domain.user.repository.UserRepository;
import poison.global.exception.CustomException;
import poison.global.exception.ErrorCode;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public List<ReviewResponse> getUserReview(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return reviewRepository.findByUser(user.getId()).stream()
                .map(ReviewResponse::from)
                .collect(Collectors.toList());
    }
}

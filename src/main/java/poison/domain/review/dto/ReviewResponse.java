package poison.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import poison.domain.review.entity.Review;

@Builder
@Getter
public class ReviewResponse {
    private String reviewId;
    private Integer stars;
    private String text;

    public static ReviewResponse from(Review review) {
        return ReviewResponse.builder()
                .reviewId(review.getId())
                .stars(review.getStars())
                .text(review.getText())
                .build();
    }
}

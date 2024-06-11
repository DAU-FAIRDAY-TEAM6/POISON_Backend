package poison.domain.review.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import poison.domain.review.dto.ReviewResponse;
import poison.domain.review.service.ReviewService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/page/review")
    public String getUserReview() {
        return "review/review";
    }

    @ResponseBody
    @GetMapping("/review")
    public List<ReviewResponse> getUserReview(@AuthenticationPrincipal User user, Model model) {
        List<ReviewResponse> reviewResponseList = reviewService.getUserReview(user.getUsername());

        return reviewResponseList;
    }

}
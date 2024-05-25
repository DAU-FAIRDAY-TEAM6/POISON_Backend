package poison.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import poison.domain.review.repository.ReviewRepository;
import poison.domain.user.repository.UserRepository;
import poison.domain.user.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/login")
    public String login() {
        return "user/login";
    }
}

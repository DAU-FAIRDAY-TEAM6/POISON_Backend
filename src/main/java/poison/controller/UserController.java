package poison.controller;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import poison.entity.User;
import poison.repository.UserRepository;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/api/user")
    public ResponseEntity<?> getBusiness() {
        User user = userRepository.findById("YtSDfk0XpyTz1KgLNPLkeg").orElseThrow(EntityExistsException::new);
        return ResponseEntity.ok(user);
    }
}

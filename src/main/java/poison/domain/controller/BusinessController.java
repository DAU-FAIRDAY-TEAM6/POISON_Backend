package poison.domain.controller;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import poison.domain.repository.BusinessRepository;
import poison.domain.entity.Business;

@RestController
@RequiredArgsConstructor
public class BusinessController {
    private final BusinessRepository businessRepository;

    @GetMapping("/api/business")
    public ResponseEntity<?> getBusiness() {
        Business business = businessRepository.findById("8wf4qYhu0miI6FzhZ5_mLQ").orElseThrow(EntityExistsException::new);
        return ResponseEntity.ok(business);
    }
}

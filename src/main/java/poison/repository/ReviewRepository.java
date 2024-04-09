package poison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poison.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
}

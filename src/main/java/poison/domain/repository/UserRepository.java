package poison.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poison.domain.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u.id from User u where size(u.reviewList) >= 10")
    List<String> findOverTenReviewUser();
}

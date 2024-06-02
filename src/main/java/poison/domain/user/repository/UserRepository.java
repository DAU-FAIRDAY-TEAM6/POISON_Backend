package poison.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poison.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select count(u.id) from User u where size(u.reviewList) >= 10")
    int findOverTenReviewUser();

    @Query("select count (u) from User u where (select count (r) FROM Review r WHERE r.user = u and r.business.city = 'Philadelphia') >= 10")
    Long countOverTenReviewUser();

    Optional<User> findByName(UserRepository userRepository);
}

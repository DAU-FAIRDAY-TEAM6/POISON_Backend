package poison.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import poison.domain.entity.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
    @Query("select count(r) from Review r where r.user.id in :userIdList and LENGTH(r.text) <= 512")
    List<Review> findByUserList(@Param("userIdList") List<String> userIdList);
}

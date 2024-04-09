package poison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poison.entity.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {
}

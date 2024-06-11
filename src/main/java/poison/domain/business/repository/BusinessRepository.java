package poison.domain.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poison.domain.business.entity.Business;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {
    @Query("select b from Business b where b.latitude between :swLat and :neLat and b.longitude between :swLng and :neLng")
    List<Business> findBusinessOnMap(double neLat, double neLng, double swLat, double swLng);
}

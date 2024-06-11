package poison.domain.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poison.domain.business.entity.Business;
import poison.domain.business.repository.BusinessRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BusinessService {
    private final BusinessRepository businessRepository;

    public List<Business> getBusinessOnMap(double neLat, double neLng, double swLat, double swLng) {
        List<Business> businessOnMap = businessRepository.findBusinessOnMap(neLat, neLng, swLat, swLng);
        return businessOnMap;
    }
}

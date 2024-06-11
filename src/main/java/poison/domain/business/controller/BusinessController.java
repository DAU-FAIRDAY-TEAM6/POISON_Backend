package poison.domain.business.controller;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import poison.domain.business.repository.BusinessRepository;
import poison.domain.business.entity.Business;
import poison.domain.business.service.BusinessService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BusinessController {
    private final BusinessService businessService;
    @GetMapping("/page/main")
    public String main() {
        return "main/main";
    }

    @ResponseBody
    @GetMapping("/api/business/map")
    public List<Business> getMapBounds(@RequestParam("neLat") double neLat,
                               @RequestParam("neLng") double neLng,
                               @RequestParam("swLat") double swLat,
                               @RequestParam("swLng") double swLng) {

        List<Business> businessOnMap = businessService.getBusinessOnMap(neLat, neLng, swLat, swLng);

        // 필요한 처리 후 적절한 응답을 반환합니다.
        return businessOnMap;
    }
}

package poison.domain.business.dto;

import lombok.Builder;
import lombok.Getter;
import poison.domain.business.entity.Business;

@Getter
@Builder
public class BusinessResponse {
    private String businessId;
    private String name;
    private String address;
    private String city;
    private Double latitude;
    private Double longitude;

    public static BusinessResponse from(Business business) {
        return BusinessResponse.builder()
                .businessId(business.getId())
                .name(business.getName())
                .address(business.getAddress())
                .city(business.getCity())
                .latitude(business.getLatitude())
                .longitude(business.getLongitude())
                .build();
    }
}

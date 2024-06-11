package poison.domain.business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "business")
public class Business {

    @Id
    @Column(name = "business_id")
    private String id;
    private String name;
    private String address;
    private String city;
    private Double latitude;
    private Double longitude;

    @Builder
    public Business(String name, String address, String city, Double latitude, Double longitude) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
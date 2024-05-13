package poison.domain.review.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import poison.domain.business.entity.Business;
import poison.domain.user.entity.User;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "review_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    private Integer stars;

    @Lob
    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;
}

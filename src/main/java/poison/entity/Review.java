package poison.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

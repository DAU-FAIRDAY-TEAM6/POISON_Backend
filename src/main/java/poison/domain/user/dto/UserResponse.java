package poison.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import poison.domain.user.entity.User;

@Getter
@Builder
public class UserResponse {
    private String userId;
    private String name;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .build();
    }
}
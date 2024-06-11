package poison.global.security;

import lombok.*;
import poison.domain.user.entity.Role;

@Builder
@Getter
@ToString
public class UserDto {
    private String id;
    private Role role;
}

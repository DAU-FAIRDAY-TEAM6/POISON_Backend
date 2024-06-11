package poison.global.security;

import lombok.*;
import poison.domain.user.entity.Role;

@Builder
@Getter
@ToString
public class MemberDto {
    private Long id;
    private Role role;
}

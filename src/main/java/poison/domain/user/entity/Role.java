package poison.domain.user.entity;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_USER("회원"),
    ROLE_ADMIN("관리자");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}

package poison.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import poison.domain.user.entity.Role;
import poison.domain.user.entity.User;
import poison.domain.user.repository.UserRepository;
import poison.global.exception.CustomException;
import poison.global.exception.ErrorCode;

@RequiredArgsConstructor
@Service
public class UserDetailServiceCustom implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getId())
                .password(passwordEncoder.encode(user.getId()))
                .authorities(Role.ROLE_USER.name())
                .build();
    }
}

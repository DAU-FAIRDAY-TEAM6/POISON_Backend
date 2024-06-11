package poison.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
public class AuthenticationProviderCustom implements AuthenticationProvider {
    private final UserDetailServiceCustom userDetailServiceCustom;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        PrincipalDetails principalDetails = (PrincipalDetails) userDetailServiceCustom.loadUserByUsername(username);

        if (principalDetails == null) {
            throw new AuthenticationException("User not found") {};
        }

        return new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

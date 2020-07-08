package zhouyf.testing;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

/**
 * @author Zhouyf
 * @Data 2020-05-27  16:19
 */

public class SecurityContextHolderTest {

    public static void main(String[] args) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication =
                new TestingAuthenticationToken("username", "password", "ROLE_USER");
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        SecurityContext context1 = SecurityContextHolder.getContext();
        Authentication authentication1 = context1.getAuthentication();
        String username = authentication1.getName();
        Object principal = authentication1.getPrincipal();
        System.out.println(username);
        System.out.println(principal);
        Collection<? extends GrantedAuthority> authorities = authentication1.getAuthorities();
    }

}

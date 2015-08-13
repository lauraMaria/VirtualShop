package virtualShop.authentication_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import virtualShop.dto.UserDTO;
import virtualShop.dto.UserRole;
import virtualShop.service.UserService;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDTO userDTO = userService.getUserByUsername(authentication.getName());
        if(userDTO.getPassword().equals(authentication.getCredentials()) == false){
            throw new BadCredentialsException("Wrong password");
        } else {
            String role = "";
            if (userDTO.getRole().equals(UserRole.PREMIUM)) {
                role = "PREMIUM";
            }else {
                role = "STANDARD";
            }

            return new UsernamePasswordAuthenticationToken(
                    authentication.getName(),
                    authentication.getCredentials(),
                    CustomAuthenticationHelper.getAuthorities(role));

        }
    }

    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));
    }
}

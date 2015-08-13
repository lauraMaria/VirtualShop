package virtualShop.authentication_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import virtualShop.dto.UserDTO;
import virtualShop.dto.UserRole;
import virtualShop.service.UserService;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        UserDTO userDTO = userService.getUserByUsername(username);
        String role = "";
        if (userDTO.getRole().equals(UserRole.PREMIUM)) {
            role = "PREMIUM";
        }else {
            role = "STANDARD";
        }
        userDetails = new User(userDTO.getUsername(),userDTO.getPassword(),true,true,true,true, CustomAuthenticationHelper.getAuthorities(role));
        return userDetails;
    }
}

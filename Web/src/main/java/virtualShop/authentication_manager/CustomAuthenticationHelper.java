package virtualShop.authentication_manager;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/10/2015.
 */
public class CustomAuthenticationHelper {

    public static Collection<GrantedAuthority> getAuthorities(String access){
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        if(access.equalsIgnoreCase("PREMIUM")){
            authorityList.add(new SimpleGrantedAuthority("ROLE_PREMIUM"));
        }else {
            authorityList.add(new SimpleGrantedAuthority("ROLE_STANDARD"));
        }
        return authorityList;
    }
}

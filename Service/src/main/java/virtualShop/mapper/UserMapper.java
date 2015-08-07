package virtualShop.mapper;

import virtualShop.dto.UserDTO;
import virtualShop.dto.UserRole;
import virtualShop.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 *
 *  <p>
 *      UserMapper is used to map a DTO type to ENTITY type
 *  </p>
 *
 */
public class UserMapper {

    public static UserDTO mapUserEntityToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getIduser());
        userDTO.setUsername(user.getUsername());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstname());
        userDTO.setLastName(user.getLastname());
        userDTO.setEmail(user.getEmail());
        if(user.getType() == 0){
            userDTO.setRole(UserRole.STANDARD);
        }else {
            userDTO.setRole(UserRole.PREMIUM);
        }

        return userDTO;
    }

    public static User mapUserDTOtoUserEntity(UserDTO userDTO){
        User user = new User();
        user.setIduser(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFirstname(userDTO.getFirstName());
        user.setLastname(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        if(userDTO.getRole() == UserRole.STANDARD){
            user.setType(0);
        } else {
            user.setType(1);
        }
        return user;
    }

    public static List<UserDTO> mapListUserEntityToListDTO(List<User> users){
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for(User user : users){
            UserDTO userDTO = UserMapper.mapUserEntityToUserDTO(user);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }
}

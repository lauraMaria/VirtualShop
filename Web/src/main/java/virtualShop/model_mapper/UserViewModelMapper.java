package virtualShop.model_mapper;

import virtualShop.dto.UserDTO;
import virtualShop.dto.UserRole;
import virtualShop.view_model.RegistrationViewModel;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
public class UserViewModelMapper {

    public static UserDTO mapRegistrationViewModelToUserDTO(RegistrationViewModel registrationViewModel){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(registrationViewModel.getFirstName());
        userDTO.setLastName(registrationViewModel.getLastName());
        userDTO.setEmail(registrationViewModel.getEmail());
        userDTO.setRole(UserRole.STANDARD);
        userDTO.setUsername(registrationViewModel.getUsername());
        userDTO.setPassword(registrationViewModel.getPassword());

        return userDTO;
    }
}

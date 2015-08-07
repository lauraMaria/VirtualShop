package virtualShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import virtualShop.dao.UserDAO;
import virtualShop.dto.UserDTO;
import virtualShop.mapper.UserMapper;
import virtualShop.service.UserService;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDTO getUserById(int id) {
        return UserMapper.mapUserEntityToUserDTO(userDAO.getObjectById(id));
    }

    public void save(UserDTO user) {
        userDAO.save(UserMapper.mapUserDTOtoUserEntity(user));
    }

    public List<UserDTO> getAllUsers() {
        return UserMapper.mapListUserEntityToListDTO(userDAO.getAllObjects());
    }

    public void delete(int id) {
        userDAO.delete(id);
    }
}

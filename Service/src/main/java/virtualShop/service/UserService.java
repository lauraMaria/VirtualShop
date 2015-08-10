package virtualShop.service;

import virtualShop.dto.UserDTO;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public interface UserService {

    public UserDTO getUserById(int id);

    public void save(UserDTO user);

    public List<UserDTO> getAllUsers();

    public void delete(int id);

    public UserDTO getUserByUsername(String username);

}

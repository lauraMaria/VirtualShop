package virtualShop.dao;

import virtualShop.entity.User;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public interface UserDAO extends GenericDAO<User> {

    public User getUserByUsername(String username);

    public boolean checkUsernameAvailability(String username, int userId);

}

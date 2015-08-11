package virtualShop.dao.impl;

import virtualShop.dao.UserDAO;
import virtualShop.entity.User;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/6/2015.
 */
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO{

    public UserDAOImpl(){
        super(User.class);
    }

    public User getUserByUsername(String username) {

        Query query = getEntityManager().createQuery("SELECT u FROM User u WHERE u.username=:usernameParam");
        query.setParameter("usernameParam",username);
        return (User) query.getSingleResult();
    }

    public boolean checkUsernameAvailability(String username, int userId) {

        Query query = getEntityManager().createQuery("SELECT COUNT(*) FROM User u WHERE u.username=:usernameParam AND u.iduser<>:idParam");
        query.setParameter("usernameParam", username);
        query.setParameter("idParam",userId);
        Long count = (Long) query.getSingleResult();
        if(count > 0){
            return true;
        }
        return false;
    }
}

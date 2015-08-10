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

        List<User> users = new ArrayList<User>();
        Query query = getEntityManager().createQuery("SELECT u FROM User u WHERE u.username=:usernameParam").setParameter("usernameParam",username);
        users = query.getResultList();
        if(users.size()>0){
            return users.get(0);
        }
        return null;
    }
}

package virtualShop.dao.impl;

import virtualShop.dao.UserDAO;
import virtualShop.entity.User;

/**
 * Created by laura.petrosanu on 8/6/2015.
 */
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO{

    public UserDAOImpl(){
        super(User.class);
    }


}

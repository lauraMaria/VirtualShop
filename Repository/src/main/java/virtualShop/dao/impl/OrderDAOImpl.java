package virtualShop.dao.impl;

import virtualShop.dao.OrderDAO;
import virtualShop.entity.Order;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderDAOImpl extends GenericDAOImpl<Order> implements OrderDAO {

    public OrderDAOImpl(){
        super(Order.class);
    }
}

package virtualShop.dao;

import virtualShop.entity.Order;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public interface OrderDAO extends GenericDAO<Order>{

    public Order addNewOrder(Order order);

    public List<Order> getOrdersByUserId(int userID);

}

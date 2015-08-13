package virtualShop.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import virtualShop.dao.OrderDAO;
import virtualShop.entity.Order;


import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderDAOImpl extends GenericDAOImpl<Order> implements OrderDAO {

    public OrderDAOImpl(){
        super(Order.class);
    }

    @Transactional
    public Order addNewOrder(Order order) {
        getEntityManager().persist(order);
        return getEntityManager().find(Order.class,order.getIdorder());
    }

    public List<Order> getOrdersByUserId(int userID) {
        List<Order> orders = new ArrayList<Order>();

        Query query = getEntityManager().createQuery("SELECT o from Order o where o.user.iduser=:idParam");
        query.setParameter("idParam", userID);
        orders = query.getResultList();
        return orders;
    }
}

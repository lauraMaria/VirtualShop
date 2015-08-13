package virtualShop.dao.impl;

import virtualShop.dao.OrderProductDAO;
import virtualShop.entity.OrderProduct;


import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderProductDAOImpl extends GenericDAOImpl<OrderProduct> implements OrderProductDAO {

    public OrderProductDAOImpl(){
        super(OrderProduct.class);
    }

    public List<OrderProduct> getOrderedProductsByOrderId(int id, int userId) {

        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();

        Query query = getEntityManager().createQuery("SELECT op FROM OrderProduct op WHERE op.order.idorder=:orderIdParam AND op.order.user.iduser=:idUserParam");
        query.setParameter("orderIdParam",id);
        query.setParameter("idUserParam", userId);
        orderProducts = query.getResultList();
        return orderProducts;
    }
}

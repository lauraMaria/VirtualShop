package virtualShop.dao.impl;

import virtualShop.dao.OrderProductDAO;
import virtualShop.entity.OrderProduct;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderProductDAOImpl extends GenericDAOImpl<OrderProduct> implements OrderProductDAO {

    public OrderProductDAOImpl(){
        super(OrderProduct.class);
    }
}

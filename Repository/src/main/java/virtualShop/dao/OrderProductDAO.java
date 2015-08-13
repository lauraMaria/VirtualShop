package virtualShop.dao;

import virtualShop.entity.OrderProduct;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public interface OrderProductDAO extends GenericDAO<OrderProduct> {

    public List<OrderProduct> getOrderedProductsByOrderId(int id, int userId);

}

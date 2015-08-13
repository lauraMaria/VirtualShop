package virtualShop.service;

import virtualShop.dto.OrderProductDTO;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/12/2015.
 */
public interface OrderProductService {

    public void save(OrderProductDTO orderProductDTO);

    public List<OrderProductDTO> getOrderedProductsByOrderId(int orderId, int userId);
}

package virtualShop.service;

import virtualShop.dto.OrderDTO;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public interface OrderService {

    public OrderDTO getOrderById(int id);

    public void save(OrderDTO order);

    public List<OrderDTO> getAllOrders();

    public void delete(int id);

    public OrderDTO addNewOrder(OrderDTO orderDTO);

    public List<OrderDTO> getOrdersById(int id);
}

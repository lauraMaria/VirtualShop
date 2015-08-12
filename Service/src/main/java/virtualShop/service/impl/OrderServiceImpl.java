package virtualShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import virtualShop.dao.OrderDAO;
import virtualShop.dto.OrderDTO;
import virtualShop.mapper.OrderMapper;
import virtualShop.service.OrderService;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public OrderDTO getOrderById(int id) {
        return OrderMapper.mapOrderEntityToOrderDTO(orderDAO.getObjectById(id));
    }

    public void save(OrderDTO order) {
        orderDAO.save(OrderMapper.mapOrderDTOToOrderEntity(order));
    }

    public List<OrderDTO> getAllOrders() {
        return OrderMapper.mapListOrderEntityToListDTO(orderDAO.getAllObjects());
    }

    public void delete(int id) {
        orderDAO.delete(id);
    }

    public OrderDTO addNewOrder(OrderDTO orderDTO) {
        return OrderMapper.mapOrderEntityToOrderDTO(orderDAO.addNewOrder(OrderMapper.mapOrderDTOToOrderEntity(orderDTO)));
    }

    public List<OrderDTO> getOrdersById(int id) {
        return OrderMapper.mapListOrderEntityToListDTO(orderDAO.getOrdersByUserId(id));
    }
}

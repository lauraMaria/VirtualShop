package virtualShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import virtualShop.dao.OrderProductDAO;
import virtualShop.dto.OrderProductDTO;
import virtualShop.mapper.OrderProductMapper;
import virtualShop.service.OrderProductService;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/12/2015.
 */
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductDAO orderProductDAO;

    public void save(OrderProductDTO orderProductDTO) {
        orderProductDAO.save(OrderProductMapper.mapOrderProductDTOToOrderProductEntity(orderProductDTO));
    }

    public List<OrderProductDTO> getOrderedProductsByOrderId(int orderId, int userId) {
        return OrderProductMapper.mapListOrderProductEntityToListDTO(orderProductDAO.getOrderedProductsByOrderId(orderId, userId));
    }
}

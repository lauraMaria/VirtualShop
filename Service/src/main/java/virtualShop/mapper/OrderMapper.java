package virtualShop.mapper;


import virtualShop.dto.OrderDTO;
import virtualShop.entity.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderMapper {

    public static OrderDTO mapOrderEntityToOrderDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setIdOrder(order.getIdorder());
        orderDTO.setDate(order.getOrderdate());
        orderDTO.setAmount(order.getAmount());
        orderDTO.setUser(UserMapper.mapUserEntityToUserDTO(order.getUser()));
        //lista de orderproducts ????

        return orderDTO;
    }

    public static Order mapOrderDTOToOrderEntity(OrderDTO orderDTO){

        Order order = new Order();
        order.setIdorder(orderDTO.getIdOrder());
        order.setOrderdate(orderDTO.getDate());
        order.setAmount(orderDTO.getAmount());
        order.setUser(UserMapper.mapUserDTOtoUserEntity(orderDTO.getUser()));

        //lista de orderproducts ????

        return order;
    }

    public static List<OrderDTO> mapListOrderEntityToListDTO(List<Order> orders){

        List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
        for(Order order : orders){
            OrderDTO orderDTO = OrderMapper.mapOrderEntityToOrderDTO(order);
            orderDTOs.add(orderDTO);
        }
        return orderDTOs;
    }

}

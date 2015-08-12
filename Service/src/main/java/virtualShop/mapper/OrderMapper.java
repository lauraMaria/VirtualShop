package virtualShop.mapper;


import virtualShop.dto.OrderDTO;
import virtualShop.dto.OrderProductDTO;
import virtualShop.dto.UserDTO;
import virtualShop.entity.Order;
import virtualShop.entity.OrderProduct;

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
        UserDTO userDTO = null;
        orderDTO.setUser(UserMapper.mapUserEntityToUserDTO(order.getUser()));
        //orderDTO.setProductDTOList(OrderProductMapper.mapListOrderProductDTOToListEntity(order.getOrderProducts()));

        return orderDTO;
    }

    public static Order mapOrderDTOToOrderEntity(OrderDTO orderDTO){

        Order order = new Order();
        order.setIdorder(orderDTO.getIdOrder());
        order.setOrderdate(orderDTO.getDate());
        order.setAmount(orderDTO.getAmount());
        order.setUser(UserMapper.mapUserDTOtoUserEntity(orderDTO.getUser()));
        if(orderDTO.getProductDTOList() != null){
            List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
            for(OrderProductDTO orderProductDTO : orderDTO.getProductDTOList()){
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setIdorderproduct(0);
                orderProduct.setOrder(order);
                orderProduct.setProduct(ProductMapper.mapProductDTOToProductEntity(orderProductDTO.getProductDTO()));
                orderProduct.setQuantity(orderProductDTO.getQuantity());
                orderProduct.setPrice(orderProductDTO.getPrice());
                orderProducts.add(orderProduct);
            }
            order.setOrderProducts(orderProducts);
        }


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

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
        List<OrderProductDTO> orderProductDTOs = new ArrayList<OrderProductDTO>();
        if(order.getOrderProducts() != null){
            for(OrderProduct orderProduct : order.getOrderProducts()){
                OrderProductDTO orderProductDTO = new OrderProductDTO();
                orderProductDTO.setIdOrderedProduct(orderProduct.getIdorderproduct());
                orderProductDTO.setOrderDTO(orderDTO);
                orderProductDTO.setQuantity(orderProduct.getQuantity());
                orderProductDTO.setPrice(orderProduct.getPrice());
                orderProductDTO.setProductDTO(ProductMapper.mapProductEntityToProductDTO(orderProduct.getProduct()));
                orderProductDTOs.add(orderProductDTO);
            }
        }
        orderDTO.setProductDTOList(orderProductDTOs);
        return orderDTO;
    }

    public static Order mapOrderDTOToOrderEntity(OrderDTO orderDTO){

        Order order = new Order();
        order.setIdorder(orderDTO.getIdOrder());
        order.setOrderdate(orderDTO.getDate());
        order.setAmount(orderDTO.getAmount());
        order.setUser(UserMapper.mapUserDTOtoUserEntity(orderDTO.getUser()));
        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        if(orderDTO.getProductDTOList() != null){
            for(OrderProductDTO orderProductDTO : orderDTO.getProductDTOList()){
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setIdorderproduct(0);
                orderProduct.setOrder(order);
                orderProduct.setProduct(ProductMapper.mapProductDTOToProductEntity(orderProductDTO.getProductDTO()));
                orderProduct.setQuantity(orderProductDTO.getQuantity());
                orderProduct.setPrice(orderProductDTO.getPrice());
                orderProducts.add(orderProduct);
            }
        }
        order.setOrderProducts(orderProducts);

        return order;
    }

    public static List<OrderDTO> mapListOrderEntityToListDTO(List<Order> orders){
        List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
        for(Order order : orders){
            orderDTOs.add(mapOrderEntityToOrderDTO(order));
        }
        return orderDTOs;
    }



}

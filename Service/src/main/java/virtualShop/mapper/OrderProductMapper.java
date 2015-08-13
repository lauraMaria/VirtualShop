package virtualShop.mapper;

import virtualShop.dto.OrderProductDTO;
import virtualShop.entity.OrderProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderProductMapper {

    public static OrderProduct mapOrderProductDTOToOrderProductEntity(OrderProductDTO orderProductDTO){

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setIdorderproduct(orderProductDTO.getIdOrderedProduct());
        orderProduct.setPrice(orderProductDTO.getPrice());
        orderProduct.setQuantity(orderProductDTO.getQuantity());
        orderProduct.setProduct(ProductMapper.mapProductDTOToProductEntity(orderProductDTO.getProductDTO()));
        orderProduct.setOrder(OrderMapper.mapOrderDTOToOrderEntity(orderProductDTO.getOrderDTO()));

        return orderProduct;

    }

    public static OrderProductDTO mapOrderProductEntityToOrderProductDTO(OrderProduct orderProduct){

        OrderProductDTO orderProductDTO = new OrderProductDTO();
        orderProductDTO.setIdOrderedProduct(orderProduct.getIdorderproduct());
        orderProductDTO.setPrice(orderProduct.getPrice());
        orderProductDTO.setQuantity(orderProduct.getQuantity());
        orderProductDTO.setOrderDTO(OrderMapper.mapOrderEntityToOrderDTO(orderProduct.getOrder()));
        orderProductDTO.setProductDTO(ProductMapper.mapProductEntityToProductDTO(orderProduct.getProduct()));

        return orderProductDTO;

    }

    public static List<OrderProduct> mapListOrderProductDTOToListEntity(List<OrderProductDTO> orderProductDTOs){

        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        for(OrderProductDTO orderProductDTO : orderProductDTOs){
            orderProducts.add(OrderProductMapper.mapOrderProductDTOToOrderProductEntity(orderProductDTO));
        }
        return orderProducts;
    }

    public static List<OrderProductDTO> mapListOrderProductEntityToListDTO(List<OrderProduct> orderProducts){
        List<OrderProductDTO> orderProductDTOs = new ArrayList<OrderProductDTO>();
        for(OrderProduct orderProduct : orderProducts){
            orderProductDTOs.add(OrderProductMapper.mapOrderProductEntityToOrderProductDTO(orderProduct));
        }
        return orderProductDTOs;
    }

}

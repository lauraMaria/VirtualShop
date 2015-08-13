package virtualShop.mapper;

import virtualShop.dto.ProductDTO;
import virtualShop.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class ProductMapper {

    public static ProductDTO mapProductEntityToProductDTO(Product product){

        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(product.getIdproduct());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImageSrc(product.getImageSrc());
        productDTO.setShortName(product.getShortName());
        //lista de ordered products ?????
        return productDTO;

    }

    public static Product mapProductDTOToProductEntity(ProductDTO productDTO){

        Product product = new Product();
        product.setIdproduct(productDTO.getIdProduct());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageSrc(productDTO.getImageSrc());
        product.setShortName(productDTO.getShortName());
        //lista de ordered products ????

        return product;

    }

    public static List<ProductDTO> mapListProductEntityToListDTO(List<Product> products){
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for(Product product : products){
            productDTOs.add(ProductMapper.mapProductEntityToProductDTO(product));
        }
        return productDTOs;
    }
}

package virtualShop.mapper;

import virtualShop.dto.ProductDTO;
import virtualShop.entity.Product;

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
        //lista de ordered products ?????
        return productDTO;

    }

    public static Product mapProductDTOToProductEntity(ProductDTO productDTO){

        Product product = new Product();
        product.setIdproduct(productDTO.getIdProduct());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        //lista de ordered products ????

        return product;

    }
}

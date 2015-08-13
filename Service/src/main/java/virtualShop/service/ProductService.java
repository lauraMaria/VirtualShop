package virtualShop.service;

import virtualShop.dto.ProductDTO;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
public interface ProductService {

    public List<ProductDTO> getAllProducts();

    public ProductDTO getProductById(int id);

}

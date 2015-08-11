package virtualShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import virtualShop.dao.ProductDAO;
import virtualShop.dto.ProductDTO;
import virtualShop.mapper.ProductMapper;
import virtualShop.service.ProductService;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<ProductDTO> getAllProducts() {
        return ProductMapper.mapListProductEntityToListDTO(productDAO.getAllObjects());
    }
}

package virtualShop.dao.impl;

import virtualShop.dao.ProductDAO;
import virtualShop.entity.Product;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class ProductDAOImpl extends GenericDAOImpl<Product> implements ProductDAO {

    public ProductDAOImpl(){
        super(Product.class);
    }
}

package virtualShop.view_model;

import virtualShop.dto.ProductDTO;


/**
 * Created by laura.petrosanu on 8/12/2015.
 */
public class CartViewModel {

    private ProductDTO productDTO;
    private int quantity;
    private float totalPrice;

    public CartViewModel(){
        quantity = 1;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPriceCost() {
        this.totalPrice = productDTO.getPrice() * quantity;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}

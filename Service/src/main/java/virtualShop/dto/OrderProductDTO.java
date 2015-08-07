package virtualShop.dto;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderProductDTO {

    private int idOrderedProduct;
    private OrderDTO orderDTO;
    private ProductDTO productDTO;
    private int quantity;
    private float price;

    public int getIdOrderedProduct() {
        return idOrderedProduct;
    }

    public void setIdOrderedProduct(int idOrderedProduct) {
        this.idOrderedProduct = idOrderedProduct;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

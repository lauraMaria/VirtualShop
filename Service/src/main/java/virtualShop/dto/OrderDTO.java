package virtualShop.dto;


import java.util.Date;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderDTO {

    private int idOrder;
    private UserDTO user;
    private float amount;
    private Date date;
    private List<OrderProductDTO> productDTOList;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public void setProductDTOList(List<OrderProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }
}

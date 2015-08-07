package virtualShop.dto;


import java.util.Date;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class OrderDTO {

    private int idOrder;
    private UserDTO user;
    private float amount;
    private Date date;

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
}

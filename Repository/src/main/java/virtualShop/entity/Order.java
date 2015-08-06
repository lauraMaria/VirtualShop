package virtualShop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/6/2015.
 */
@Entity
public class Order implements DomainEntity{

    /**
     * database identifier for and Order
     */
    @Id
    @GeneratedValue
    private long idOrder;
    /**
     * the total value of a submitted Order
     */
    private float amount;

    /**
     * the author of the Order
     */
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    //getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }



}

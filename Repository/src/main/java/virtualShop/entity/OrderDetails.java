package virtualShop.entity;

import javax.persistence.*;

/**
 * Created by laura.petrosanu on 8/6/2015.
 */
@Entity
public class OrderDetails implements DomainEntity{

    /**
     * database identifier for OrderDetails
     */
    @Id
    @GeneratedValue
    private long idOrderDetails;


    public long getIdOrderDetails() {
        return idOrderDetails;
    }

    public void setIdOrderDetails(long idOrderDetails) {
        this.idOrderDetails = idOrderDetails;
    }


}

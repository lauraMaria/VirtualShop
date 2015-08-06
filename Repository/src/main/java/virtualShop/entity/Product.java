package virtualShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by laura.petrosanu on 8/6/2015.
 */
@Entity
public class Product implements DomainEntity{

    /**
     * database identifier for a Product
     */
    @Id
    @GeneratedValue
    private long idProduct;
    /**
     * the name of the Product
     */
    private String name;
    /**
     * the description of the Product
     */
    private String description;

    //getters and setters
    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

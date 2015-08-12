package virtualShop.entity;

import javax.persistence.*;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
@Entity
public class OrderProduct {

    /**
     * database identifier for the Order
     */

    private int idorderproduct;
    /**
     * ordered quantity of the Product
     */
    private int quantity;
    /**
     * paid amount
     */
    private float price;
    /**
     * the product added
     */
    private Product product;
    /**
     * the corresponding order
     */
    private Order order;

    @Id
    @Column(name = "idorderproduct")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdorderproduct() {
        return idorderproduct;
    }

    public void setIdorderproduct(int idorderproduct) {
        this.idorderproduct = idorderproduct;
    }



    @ManyToOne
    @JoinColumn(name="idproduct", referencedColumnName = "idproduct")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @ManyToOne
    @JoinColumn(name = "idorder", referencedColumnName = "idorder")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //getters and setters


    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}

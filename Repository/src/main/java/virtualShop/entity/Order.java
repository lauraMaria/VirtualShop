package virtualShop.entity;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
@Entity
public class Order {
    /**
     * database identifier for a Order
     */
    private int idorder;
    /**
     * total value of a order
     */
    private float amount;
    /**
     * the date when the order is placed
     */
    private Date orderdate;
    /**
     * the user which makes the order
     */
    private User user;


    private List<OrderProduct> orderProducts;

    //getters and setters

    @Id
    @Column(name = "idorder")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    @Basic
    @Column(name = "amount")
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "orderdate")
    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  mappedBy = "order")
    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idorder != order.idorder) return false;
        if (orderdate != null ? !orderdate.equals(order.orderdate) : order.orderdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idorder;
        result = 31 * result + (orderdate != null ? orderdate.hashCode() : 0);
        return result;
    }
}

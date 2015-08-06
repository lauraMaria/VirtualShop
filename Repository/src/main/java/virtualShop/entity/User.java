package virtualShop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/6/2015.
 */
@Entity
public class User implements DomainEntity{

    /**
     * database identifier of a User
     */
    @Id
    @GeneratedValue
    private long idUser;
    /**
     * the user name of a User
     */
    private String userName;
    /**
     * the password of a User
     */
    private String password;
    /**
     * first name of the User
     */
    private String firstName;
    /**
     * last name of the User
     */
    private String lastName;
    /**
     * email of the User
     */
    private String email;
    /**
     * the list of the Order for a User
     */
    @OneToMany(mappedBy = "user")
    private List<Order> orderList;
    /**
     * the role of a User

     */
    @ManyToOne
    @JoinColumn(name = "iduserrole")
    private UserRole role;

    //getters and setters
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}

package virtualShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/6/2015.
 */
@Entity
public class UserRole implements DomainEntity{

    /**
     * database identifier for a UserRole
     */
    @Id
    @GeneratedValue
    private long idRole;
    /**
     * the role of the User
     */
    private String role;
    /**
     * the list of users having a UserRole
     */
    @OneToMany(mappedBy = "role")
    private List<User> users;

    //getters and setters
    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}

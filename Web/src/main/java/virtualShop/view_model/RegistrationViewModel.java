package virtualShop.view_model;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
public class RegistrationViewModel {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confPassword;
    private String email;
    private String confEmail;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getConfEmail() {
        return confEmail;
    }

    public void setConfEmail(String confEmail) {
        this.confEmail = confEmail;
    }
}

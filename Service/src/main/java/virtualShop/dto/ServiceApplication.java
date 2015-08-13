package virtualShop.dto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import virtualShop.dao.impl.OrderDAOImpl;
import virtualShop.dao.impl.OrderProductDAOImpl;
import virtualShop.dao.impl.UserDAOImpl;
import virtualShop.entity.Order;
import virtualShop.entity.Product;
import virtualShop.entity.User;
import virtualShop.service.UserService;
import virtualShop.service.impl.UserServiceImpl;

/**
 * Created by laura.petrosanu on 8/10/2015.
 */
public class ServiceApplication {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("appContext-service.xml");
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");

        UserDTO userDTO = userService.getUserById(1);
        System.out.println(userDTO.getFirstName());
        System.out.println(userDTO.getLastName());
    }

}

package virtualShop.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import virtualShop.dao.impl.OrderDAOImpl;
import virtualShop.dao.impl.OrderProductDAOImpl;
import virtualShop.dao.impl.UserDAOImpl;

/**
 * Created by laura.petrosanu on 8/7/2015.
 */
public class Application {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext-repository.xml");

        OrderDAOImpl order = (OrderDAOImpl) context.getBean("orderDAO");
        UserDAOImpl userDAO = (UserDAOImpl) context.getBean("userDAO");
        User user = order.getObjectById(1).getUser();
        System.out.println(user.getFirstname());
        System.out.println(user.getLastname());

        OrderProductDAOImpl orderProductDAO = (OrderProductDAOImpl) context.getBean("orderProductDAO");
        Product p = orderProductDAO.getObjectById(2).getProduct();
        System.out.println("*******************************");
        System.out.println(p.getIdproduct());
        System.out.println(p.getName());
        System.out.println(p.getPrice());

        Order o = orderProductDAO.getObjectById(1).getOrder();
        System.out.println(o.getIdorder());
        System.out.println(o.getAmount());
    }
}

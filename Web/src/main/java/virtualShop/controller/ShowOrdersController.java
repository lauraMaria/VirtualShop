package virtualShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import virtualShop.dto.OrderDTO;
import virtualShop.dto.OrderProductDTO;
import virtualShop.dto.UserDTO;
import virtualShop.service.OrderProductService;
import virtualShop.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/12/2015.
 */
@Controller
public class ShowOrdersController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    @RequestMapping(value = "showOrders", method = RequestMethod.GET)
    public String shoOrdersGET(Model model, HttpSession session){
        //get connected user
        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        model.addAttribute("user", userDTO.getFirstName());
        //get the list of orders
        List<OrderDTO> orderDTOs = orderService.getOrdersById(userDTO.getUserId());
        model.addAttribute("orders", orderDTOs);

        return "showOrders";
    }

    @RequestMapping(value = "showOrderDetails", method = RequestMethod.GET)
    public String showOrderDetailsGET(@RequestParam("id") int id, Model model, HttpSession session){

        //get connected user
        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        model.addAttribute("user", userDTO.getFirstName());

        //get the ordered products by order id and user id
        List<OrderProductDTO> orderProductDTOs = orderProductService.getOrderedProductsByOrderId(id, userDTO.getUserId());
        if(orderProductDTOs.size() == 0){
            return "forbidden";
        } else {

            //get order details by id
            OrderDTO orderDTO = orderService.getOrderById(id);
            //output the order details
            model.addAttribute("order", orderDTO);
            //output ordered products
            model.addAttribute("products", orderProductDTOs);
            return "showOrderDetails";
        }
    }


}

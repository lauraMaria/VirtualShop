package virtualShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import virtualShop.dto.OrderDTO;
import virtualShop.dto.UserDTO;
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

    @RequestMapping(value = "showOrders", method = RequestMethod.GET)
    public String shoOrdersGET(Model model, HttpSession session){

        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        model.addAttribute("user", userDTO.getFirstName());

        List<OrderDTO> orderDTOs = orderService.getOrdersById(userDTO.getUserId());
        model.addAttribute("orders", orderDTOs);

        return "showOrders";
    }
}

package virtualShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import virtualShop.dto.UserDTO;

import javax.servlet.http.HttpSession;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
@Controller
public class MyCartController {

    @RequestMapping(value = "myCart", method = RequestMethod.GET)
    public String myCartGET(Model model, HttpSession session){

        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        model.addAttribute("user",userDTO.getFirstName());
        return "myCart";
    }

}

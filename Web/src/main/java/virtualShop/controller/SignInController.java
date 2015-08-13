package virtualShop.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import virtualShop.dto.ProductDTO;
import virtualShop.dto.UserDTO;
import virtualShop.service.ProductService;
import virtualShop.service.UserService;
import virtualShop.view_model.AccountViewModel;
import virtualShop.view_model.CartProductsViewModel;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
@Controller
public class SignInController {
    private static Logger log = LoggerFactory.getLogger(SignInController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String getSignInPage(@RequestParam(value = "error", required = false) boolean error, ModelMap modelMap) {
        log.debug("Received request to sign in");

        if (error == true) {
            log.debug("Binding errors in signIn method");
            modelMap.addAttribute("error", "Invalid username or password");

        } else {
            modelMap.put("error", "");
        }
        modelMap.addAttribute("loginForm", new AccountViewModel());
        return "signin";
    }

    @RequestMapping(value = "common", method = RequestMethod.GET)
    public String getCommonPage(Model model, Authentication authentication,
                                HttpSession session) {
        boolean isPremium = false;
        for (GrantedAuthority grantedAuthority : SecurityContextHolder
                .getContext().getAuthentication().getAuthorities()) {
            if (grantedAuthority.getAuthority().equals("ROLE_PREMIUM")) {
                isPremium = true;
                break;
            }
        }
        //create the cart and store it on session
        session.setAttribute("cartProducts", new CartProductsViewModel());

        //get the authenticated user details
        UserDTO userDTO = userService.getUserByUsername(authentication.getName());
        //save the user on session
        session.setAttribute("loggedUser", userDTO);
        //set the name of the user
        model.addAttribute("user", userDTO.getFirstName());
        List<ProductDTO> productDTOs = productService.getAllProducts();
        if (isPremium) {
            System.out.println("IS PREMIUM");
            //populate the list of products with prices for Premium customer
            List<ProductDTO> discountProducts = new ArrayList<ProductDTO>();
            for (ProductDTO productDTO : productDTOs) {
                float discount = productDTO.getPrice() - (productDTO.getPrice() * (float) 0.1);
                productDTO.setPrice(discount);
                discountProducts.add(productDTO);
            }
            model.addAttribute("list", discountProducts);

        } else {
            //populate the list of products from database
            model.addAttribute("list", productDTOs);
        }
        return "common";
    }

}

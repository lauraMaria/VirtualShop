package virtualShop.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import virtualShop.dto.ProductDTO;
import virtualShop.service.ProductService;

import java.util.List;


/**
 * Created by laura.petrosanu on 8/10/2015.
 */
@Controller
public class IndexController {

    private static Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model) {

        log.debug("Enter home method");
        System.out.println("Index Controller: Passing through...");
        //get the products from the database
        List<ProductDTO> productDTOs = productService.getAllProducts();
        System.out.println("no of products: " + productDTOs.size());
        model.addAttribute("list",productDTOs);
        return "index";
    }
}

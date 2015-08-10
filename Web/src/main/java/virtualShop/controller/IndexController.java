package virtualShop.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by laura.petrosanu on 8/10/2015.
 */
@Controller
public class IndexController {

    private static Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home() {

        log.debug("Enter home method");
        System.out.println("Index Controller: Passing through...");
        return "index";
    }
}

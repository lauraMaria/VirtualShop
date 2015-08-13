package virtualShop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import virtualShop.model_mapper.UserViewModelMapper;
import virtualShop.service.UserService;
import virtualShop.validator.RegistrationValidator;
import virtualShop.view_model.RegistrationViewModel;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
@Controller
public class RegisterController {

    @Autowired
    private RegistrationValidator registrationValidator;

    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory
            .getLogger(RegisterController.class);

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(registrationValidator);
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerPageGET(Model model) {
        log.debug("Enter registerPageGET method ");
        model.addAttribute("registerFrm", new RegistrationViewModel());

        return "register";

    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerPagePOST(@Validated @ModelAttribute("registerFrm") RegistrationViewModel
                                               registrationViewModel, BindingResult result, Model model) {

        log.debug("Enter registerPagePOST method ");
        //check for binding errors
        if(result.hasErrors()){
            log.debug("registerPagePOST method binding errors");
            //reset password
            registrationViewModel.setPassword("");
            registrationViewModel.setConfPassword("");
            model.addAttribute("registerFrm", registrationViewModel);
            return "register";
        } else {
            //check for username availability
            if(userService.checkUsernameAvailability(registrationViewModel.getUsername(),0)){
                log.debug("Selected username is already taken");
                //return registration page with appropriate error
                model.addAttribute("notAvailable", "User name already exists");
                return "register";
            } else {
                userService.save(UserViewModelMapper.mapRegistrationViewModelToUserDTO(registrationViewModel));
                log.debug("Add new user into the database");
                return "redirect:successfulRegister.html";
            }
        }
    }

    @RequestMapping(value = "successfulRegister", method = RequestMethod.GET)
    public String successRegister() {
        log.debug("Enter successRegister GET method");
        return "successfulRegister";
    }


}

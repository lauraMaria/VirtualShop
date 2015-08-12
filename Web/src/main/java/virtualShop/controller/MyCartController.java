package virtualShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import virtualShop.dto.*;
import virtualShop.entity.Order;
import virtualShop.entity.OrderProduct;
import virtualShop.entity.Product;
import virtualShop.mapper.OrderMapper;
import virtualShop.mapper.ProductMapper;
import virtualShop.mapper.UserMapper;
import virtualShop.service.OrderProductService;
import virtualShop.service.OrderService;
import virtualShop.service.ProductService;
import virtualShop.view_model.CartProductsViewModel;
import virtualShop.view_model.CartViewModel;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/11/2015.
 */
@Controller
public class MyCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    @RequestMapping(value = "myCart", method = RequestMethod.GET)
    public String myCartGET(Model model, HttpSession session) {

        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        model.addAttribute("user", userDTO.getFirstName());
        //get the cart object from session
        CartProductsViewModel cartProducts = (CartProductsViewModel) session.getAttribute("cartProducts");
        List<CartViewModel> addedProducts = cartProducts.getCartProducts();
        //output the list of products
        model.addAttribute("products", addedProducts);
        //output the cost of current cart
        model.addAttribute("cost", cartProducts.getTotalOrder());
        model.addAttribute("addOrder", new CartProductsViewModel());
        return "myCart";
    }


    @RequestMapping(value = "myCart", method = RequestMethod.POST)
    public String myCartPOST(@ModelAttribute("addOrder") CartProductsViewModel cartProductsViewModel, HttpSession session) {
        //get logged user
        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        //save the order into the database
        OrderDTO orderToBeSumitted = new OrderDTO();
        orderToBeSumitted.setUser(userDTO);
        orderToBeSumitted.setDate(new Date());
        orderToBeSumitted.setAmount(cartProductsViewModel.getTotalOrder());

        List<OrderProductDTO> products = new ArrayList<OrderProductDTO>();

        for (CartViewModel cartViewModel : cartProductsViewModel.getCartProducts()) {
            OrderProductDTO orderProductDTO = new OrderProductDTO();
            ProductDTO productDto = productService.getProductById(cartViewModel.getProductDTO().getIdProduct());
            orderProductDTO.setProductDTO(productDto);
            orderProductDTO.setOrderDTO(orderToBeSumitted);
            orderProductDTO.setQuantity(cartViewModel.getQuantity());
            orderProductDTO.setPrice(cartViewModel.getTotalPrice());
            products.add(orderProductDTO);
        }
        orderToBeSumitted.setProductDTOList(products);
        orderService.save(orderToBeSumitted);


        return "redirect:successfulOrder";
    }

    @RequestMapping(value = "/addProductToCart", method = RequestMethod.POST)
    public
    @ResponseBody
    String addProductToCart(@RequestParam("id") int id, HttpSession session) {

        //get the cart object from session
        CartProductsViewModel cartProducts = (CartProductsViewModel) session.getAttribute("cartProducts");
        List<CartViewModel> addedProducts = cartProducts.getCartProducts();
        //get the product from database by id
        ProductDTO productDTO = productService.getProductById(id);
        //create a new Cart view model object
        CartViewModel cartViewModel = new CartViewModel();
        //check if the user is PREMIUM
        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        if (userDTO.getRole().equals(UserRole.PREMIUM)) {
            //make the discount
            float discount = productDTO.getPrice() - (productDTO.getPrice() * (float) 0.1);
            productDTO.setPrice(discount);
        }
        cartViewModel.setProductDTO(productDTO);
        cartViewModel.setTotalPriceCost();
        //add the new product to cart
        addedProducts.add(cartViewModel);
        //set the total cost of the cart
        cartProducts.setTotalOrderCost();
        //save the changes
        session.setAttribute("cartProducts", cartProducts);

        return "success";
    }

    @RequestMapping(value = "successfulOrder", method = RequestMethod.GET)
    public String successfulOrderGET(Model model, HttpSession session){
        UserDTO userDTO = (UserDTO) session.getAttribute("loggedUser");
        model.addAttribute("user", userDTO.getFirstName());

        return "successfulOrder";
    }

}

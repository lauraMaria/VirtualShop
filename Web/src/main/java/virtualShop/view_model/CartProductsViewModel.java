package virtualShop.view_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/12/2015.
 */
public class CartProductsViewModel {

    private List<CartViewModel> cartProducts;
    private float totalOrder;

    public CartProductsViewModel() {
        cartProducts = new ArrayList<CartViewModel>();
        totalOrder = 0;
    }

    public List<CartViewModel> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartViewModel> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public float getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrderCost() {

        float total = 0;
        for(CartViewModel cartViewModel : cartProducts){
            total += cartViewModel.getTotalPrice();
        }
        this.totalOrder = total;
    }

    public void setTotalOrder(float totalOrder) {
        this.totalOrder = totalOrder;
    }
}

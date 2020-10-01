import models.ActivePromotion;
import models.CartItem;
import models.Product;
import promotion.engine.PromotionEngine;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // Product List
        List<Product> products = new ArrayList<>();
        Product a = new Product('A', 50);
        Product b = new Product('B', 30);
        Product c = new Product('C', 20);
        Product d = new Product('D', 15);
        products.add(a);
        products.add(b);
        products.add(c);
        products.add(d);

        CartItem cartItem1 = new CartItem(3, a);
        CartItem cartItem2 = new CartItem(5, b);
        CartItem cartItem3 = new CartItem(1, c);
        CartItem cartItem4 = new CartItem(1, d);

        // list of items SKU ids
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);
        cartItems.add(cartItem4);

        // list of active promotions
        List<ActivePromotion> promotions = new ArrayList<>();
        promotions.add(new ActivePromotion(3, Arrays.asList(a), 130));
        promotions.add(new ActivePromotion(2, Arrays.asList(b), 45));
        promotions.add(new ActivePromotion(1, Arrays.asList(c, d), 130));

        PromotionEngine engine = new PromotionEngine();
        System.out.println(cartItems);
        System.out.println(promotions);
        int f = engine.getOrderValue(cartItems, promotions);
        System.out.println(f);
    }
}

import models.ActivePromotion;
import models.CartItem;
import models.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import promotion.engine.PromotionEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromotionEngineTest {
    private List<Product> products = new ArrayList<>();
    private List<CartItem> cartItems = new ArrayList<>();
    private List<ActivePromotion> promotions = new ArrayList<>();
    PromotionEngine engine = new PromotionEngine();
    // Product List
    Product a = new Product('A', 50);
    Product b = new Product('B', 30);
    Product c = new Product('C', 20);
    Product d = new Product('D', 15);


    @Before
    public void before() {
        // create product list
        products.add(a);
        products.add(b);
        products.add(c);
        products.add(d);
        // list of active promotions
        promotions.add(new ActivePromotion(3, Arrays.asList(a), 130));
        promotions.add(new ActivePromotion(2, Arrays.asList(b), 45));
        promotions.add(new ActivePromotion(1, Arrays.asList(c, d), 30));
    }

    @Test
    public void testScenarioA() {
        CartItem cartItem1 = new CartItem(1, a);
        CartItem cartItem2 = new CartItem(1, b);
        CartItem cartItem3 = new CartItem(1, c);
        // list of items SKU ids
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);
        Assert.assertEquals(100 , engine.getOrderValue(cartItems, promotions));
    }
    @Test
    public void testScenarioB() {
        CartItem cartItem1 = new CartItem(5, a);
        CartItem cartItem2 = new CartItem(5, b);
        CartItem cartItem3 = new CartItem(1, c);
        // list of items SKU ids
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);
        Assert.assertEquals(370 , engine.getOrderValue(cartItems, promotions));
    }
    @Test
    public void testScenarioC() {
        CartItem cartItem1 = new CartItem(3, a);
        CartItem cartItem2 = new CartItem(5, b);
        CartItem cartItem3 = new CartItem(1, c);
        CartItem cartItem4 = new CartItem(1, d);
        // list of items SKU ids
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);
        cartItems.add(cartItem4);
        Assert.assertEquals(280 , engine.getOrderValue(cartItems, promotions));
    }
}

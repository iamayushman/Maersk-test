package promotion.engine;

import models.ActivePromotion;
import models.CartItem;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionEngine {
    public int getOrderValue(List<CartItem> cartItems, List<ActivePromotion> promotions) {
        int result = 0;
        // each items in cart
        List<CartItem> skipCartItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            if (skipCartItems.contains(cartItem))
                break;
            // each promotion
            for (ActivePromotion promotion : promotions) {
                // check if promotion product is available in cart
                if (promotion.getProducts().contains(cartItem.getProduct())) {
                    // if promotion have two or more items combined
                    if (promotion.getProducts().size() > 1) {
                        //
                        if (isCartContainsAllProductsInPromotion(cartItems, promotion)) {
                            skipCartItems = cartItems.stream()
                                    .filter(item -> promotion.getProducts().contains(item.getProduct()))
                                    .collect(Collectors.toList());
                            result += calculateOffer(cartItems, promotion);
                        } else {
                            result += calculateOffer(cartItem);
                        }
                        // if promotion have one item
                    } else {
                        result += calculateOffer(cartItem, promotion);
                    }
                }
            }
        }
        return result;
    }

    private boolean isCartContainsAllProductsInPromotion(List<CartItem> cartItems, ActivePromotion promotion) {
        int sum = 0;
        for (Product product : promotion.getProducts()) {
            sum += cartItems.stream().filter(item -> item.getProduct().equals(product)).count();
        }
        return sum == promotion.getProducts().size();
    }

    private int calculateOffer(List<CartItem> cartItems, ActivePromotion promotion) {
        List<CartItem> subItems = new ArrayList<>();
        for (CartItem item : cartItems) {
            if (promotion.getProducts().contains(item.getProduct())) {
                subItems.add(item);
            }
        }
        int minCommonQuantity = subItems.stream()
                                        .map(data -> data.getQuantity())
                                        .collect(Collectors.toList()).stream().mapToInt(a -> a).min().getAsInt();
        System.out.println(minCommonQuantity);
        for (CartItem item : subItems) {

        }

        return 1;
    }

    private int calculateOffer(CartItem cartItem) {
        ActivePromotion promotion = new ActivePromotion(0, null, 0);
        return calculateOffer(cartItem, promotion);
    }

    private int calculateOffer(CartItem cartItem, ActivePromotion promotion) {
        // products available for promotion
        boolean isOfferApplicable = promotion.getQuantity() == 0 ? false : cartItem.getQuantity() >= promotion.getQuantity();
        int applicableForOffer = isOfferApplicable ? cartItem.getQuantity() / promotion.getQuantity() : 0;
        // price of items where promotion are applied
        int promotionItemPrice = applicableForOffer * promotion.getPrice();
        // price of items where promotions cannot be applied
        int nonPromotedPrice = cartItem.getProduct().getPrice() * (isOfferApplicable ? (cartItem.getQuantity() % promotion.getQuantity()) : cartItem.getQuantity());
        return promotionItemPrice + nonPromotedPrice;
    }
}

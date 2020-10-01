package models;

import java.util.List;

public class ActivePromotion {
    private int quantity;
    private List<Product> products;
    private int price;

    public ActivePromotion(int quantity, List<Product> products, int price) {
        this.quantity = quantity;
        this.products = products;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ActivePromotion{" +
                "quantity=" + quantity +
                ", products=" + products +
                ", price=" + price +
                '}';
    }
}

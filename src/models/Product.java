package models;

public class Product {
    private char name;
    private int price;
    private int percentageOffer;

    public Product(char name, int price) {
        this.name = name;
        this.price = price;
        this.percentageOffer = 0;
    }

    public Product(char name, int price, int percentageOffer) {
        this.name = name;
        this.price = price;
        this.percentageOffer = percentageOffer;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPercentageOffer() {
        return percentageOffer;
    }

    public void setPercentageOffer(int percentageOffer) {
        this.percentageOffer = percentageOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name == product.name;
    }

    @Override
    public int hashCode() {
        return (int) name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", price=" + price +
                ", percentageOffer=" + percentageOffer +
                '}';
    }
}

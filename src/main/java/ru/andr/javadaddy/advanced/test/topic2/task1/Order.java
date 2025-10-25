package ru.andr.javadaddy.advanced.test.topic2.task1;

public class Order {
    private String productId;
    private int quantity;
    private double pricePerUnit;

    public Order(String productId, int quantity, double pricePerUnit) {
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double calculateTotalPrice() {
        return quantity * pricePerUnit;
    }
}

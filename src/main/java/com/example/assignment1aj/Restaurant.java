package com.example.assignment1aj;

import javafx.beans.property.*;

public class Restaurant {
    private final IntegerProperty orderid;
    private StringProperty itemname;
    public final StringProperty Customername;
    private final StringProperty orderday;
    private DoubleProperty price;

    public Restaurant(int orderId, String itemName, String customerName, String orderDay, double price) {
        this.orderid = new SimpleIntegerProperty(orderId);
        this.itemname = new SimpleStringProperty(itemName);
        this.Customername = new SimpleStringProperty(customerName);
        this.orderday = new SimpleStringProperty(orderDay);
        this.price = new SimpleDoubleProperty(price);
    }

    public Restaurant(IntegerProperty orderid, StringProperty customername, StringProperty orderday) {
        this.orderid = orderid;
        Customername = customername;
        this.orderday = orderday;
    }

    // Getter methods for JavaFX properties
    public IntegerProperty orderIdProperty() {
        return orderid;
    }

    public StringProperty itemNameProperty() {
        return itemname;
    }

    public StringProperty CustomernameProperty() {
        return Customername;
    }

    public StringProperty orderDayProperty() {
        return orderday;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    // Getter methods for non-JavaFX properties
    public int getOrderId() {
        return orderid.get();
    }

    public String getItemName() {
        return itemname.get();
    }

    public String getCustomerName() {
        return Customername.get();
    }

    public String getOrderDay() {
        return orderday.get();
    }

    public double getPrice() {
        return price.get();
    }
}

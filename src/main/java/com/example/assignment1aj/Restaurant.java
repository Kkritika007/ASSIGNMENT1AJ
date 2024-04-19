package com.example.assignment1aj;

import javafx.beans.property.*;

public class Restaurant {
    private final IntegerProperty orderid;
    private StringProperty itemname;
    public StringProperty Customername;
    private final StringProperty orderday;
    private DoubleProperty price;

    public Restaurant(int orderid, String itemname, String Customername, String orderDay, double price) {
        this.orderid = new SimpleIntegerProperty(orderid);
        this.itemname = new SimpleStringProperty(itemname);
        this.Customername = new SimpleStringProperty(Customername);
        this.orderday = new SimpleStringProperty(orderDay);
        this.price = new SimpleDoubleProperty(price);
    }

    public Restaurant(IntegerProperty orderid, StringProperty customername, StringProperty orderday) {
        this.orderid = orderid;
        Customername = customername;
        this.orderday = orderday;
    }

    // Getter methods for JavaFX properties
    public IntegerProperty orderidProperty() {
        return orderid;
    }

    public StringProperty itemnameProperty() {
        return itemname;
    }

    public StringProperty CustomernameProperty() {
        return Customername;
    }

    public StringProperty orderdayProperty() {
        return orderday;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    // Getter methods for non-JavaFX properties
    public int getorderid() {
        return orderid.get();
    }

    public String getitemname() {
        return itemname.get();
    }

    public String getCustomerName() {
        return Customername.get();
    }

    public String getorderday() {
        return orderday.get();
    }

    public double getprice() {
        return price.get();
    }
}

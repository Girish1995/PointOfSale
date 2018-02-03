package com.pointofsale.model;

/**
 * Created by Girish Grover on 1/22/2018.
 */

public class Items {

    String item_name,qty,price,left_price,discount;

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getLeft_price() {
        return left_price;
    }

    public String getQty() {
        return qty;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setLeft_price(String left_price) {
        this.left_price = left_price;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}

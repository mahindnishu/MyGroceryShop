package com.javatpoint.user.mygroceryshop;

public class Model
{
    String product_name;
    int product_price;
    int product_img;
    int qty;

    public Model(String product_name, int product_price, int product_img, int qty) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_img = product_img;
        this.qty=qty;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_img() {
        return product_img;
    }

    public void setProduct_img(int product_img) {
        this.product_img = product_img;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

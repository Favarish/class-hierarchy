package ru.eltex;


public class Sale {
    String productName;
    Integer productPrice;

    public Sale(String product, Integer priseProduct) {
        productName = product;
        productPrice = priseProduct;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}

package ru.eltex;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Manager extends User /*implements CSV */{
    ArrayList<Sale> sales;

    public Manager(String name, Integer phone, Short id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.sales = new ArrayList<>();
    }

    public Manager(@JsonProperty(value = "name")String name, @JsonProperty(value = "phone") Integer phone, @JsonProperty(value = "id") Short id, @JsonProperty(value = "sales") ArrayList<Sale> sales) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.sales = sales;
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    public ArrayList<String> getSales() {
        ArrayList<String> temp = new ArrayList<>();

        for (Sale i : sales) {
            temp.add(i.productName + " Цена: " + i.productPrice);
        }

        return temp;
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public void removeSale(Sale sale) {
        sales.remove(sale);
    }
}

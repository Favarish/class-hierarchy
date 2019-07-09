package ru.eltex;

import java.util.ArrayList;

public class Manager extends User /*implements CSV */{
    ArrayList<Sale> sales;

    public Manager(String name, Integer phone, Short id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        sales = new ArrayList<>();
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

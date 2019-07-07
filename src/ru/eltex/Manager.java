package ru.eltex;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Manager extends User /*implements CSV */{
    ArrayList<Sale> sales;

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    /*@Override
    public void createFile(String fileName) {
        File newFile = new File(System.getProperty("user.dir"), "file.csv");
    }

    @Override
    public void writeToCSVFile() {

    }*/
}

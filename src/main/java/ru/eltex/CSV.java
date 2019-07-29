package ru.eltex;

import java.io.*;
import java.util.ArrayList;

public interface CSV {
    static void writeToCSVFile(){
        String pathOut = "out.csv";

        ArrayList<User> users = Application.getUsers();

        try(FileWriter writer = new FileWriter( pathOut, false))
        {
            for (User i : users) {
                if (i.getClass().toString().equals("class ru.eltex.Developer")) {
                    writer.write(i.name + " ; " + i.phone + " ; " + i.id + " ; " + ((Developer)i).getLang() + "\n");
                } else {
                    writer.write(i.name + " ; " + i.phone + " ; " + i.id + " ; " + ((Manager)i).getSales() + "\n");
                }
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    static void readToCSVFileToConsole() {
        String path = "out.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String temp = reader.readLine();
            while (temp != null) {
                System.out.println(temp);
                temp = reader.readLine();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}

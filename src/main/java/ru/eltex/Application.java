package ru.eltex;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Application implements CSV {

    private static ArrayList<User> users = new ArrayList<>();
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static Connection connection = null;

    public static void main(String[] args) throws SQLException {

        for (int i = 0; i < 5; i++) {
            users.add(new Developer("Developer" + i, (int) (Math.random() * 10000), (short) (i + 10)));
        }

        for (int i = 0; i < 5; i++) {
            users.add(new Manager("Manager" + i, (int) (Math.random() * 10000), (short) (i + 20)));
        }

        Sale sale1 = new Sale("Компьютер", 50000);
        Sale sale2 = new Sale("Слабый компьютер", 15000);
        Sale sale3 = new Sale("Читалка", 12000);

        ((Developer) (users.get(0))).addLang("Java", "Python", "C");
        ((Developer) (users.get(1))).addLang("Ruby", "Python", "C");
        ((Developer) (users.get(2))).addLang("HTML", "CSS", "PHP");
        ((Developer) (users.get(3))).addLang("MushinLang", "Assembler", "C++");
        ((Developer) (users.get(4))).addLang("Java", "C#");

        ((Manager) (users.get(5))).addSale(sale1);
        ((Manager) (users.get(6))).addSale(sale2);
        ((Manager) (users.get(7))).addSale(sale3);
        ((Manager) (users.get(8))).addSale(sale2);
        ((Manager) (users.get(8))).addSale(sale3);
        ((Manager) (users.get(9))).addSale(sale1);
        ((Manager) (users.get(9))).addSale(sale2);
        ((Manager) (users.get(9))).addSale(sale3);


        CSV.writeToCSVFile();
        CSV.readToCSVFileToConsole();

        //Comparable
        System.out.println(users.get(0).compareTo(users.get(3)));

        //equals
        System.out.println(users.get(5).equals(users.get(6)));

        Task task1 = new Task(users.get(5), users.get(2));
        task1.setDescription("Начачаться к лету=D");

        task1.printTask();

        Dump listForJSON = new Dump(users);
        listForJSON.writeToJSON();

        ArrayList<User> testForJSONUsers = new ArrayList<>();
        testForJSONUsers = listForJSON.readToJSONFile();

        for (User user : testForJSONUsers) {
            System.out.println(user);
        }


        try {
            connection = DriverManager.getConnection(DB_URL, "root", "Enrfrhzrhz427");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS user");
            statement.executeUpdate("USE user");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS usersTable(" +
                    "id SMALLINT, " +
                    "phone VARCHAR(11), " +
                    "name TEXT, " +
                    "PRIMARY KEY (id))"
            );

            connection.setAutoCommit(false);
            try (BufferedReader reader = new BufferedReader(new FileReader("out.csv"))) {
                String temp = reader.readLine();
                while (temp != null) {
                    String[] tempStr = temp.split(" ; ");
                    statement.executeUpdate("INSERT INTO usersTable(id, phone, name) VALUE('" + tempStr[2] + "', '" +
                            tempStr[1] + "', '" + tempStr[0] + "')");
                    temp = reader.readLine();
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}

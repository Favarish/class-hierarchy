package ru.eltex;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Dump extends ArrayList<User> implements JSON{

    public Dump() {

    }

    public Dump(ArrayList<User> users) {
        for (User user : users) {
            this.add(user);
        }
    }

    @Override
    public void writeToJSON() {
        ObjectMapper mapper = new ObjectMapper();

        try (FileWriter writer = new FileWriter("sizeMass", false)){
            mapper.writeValue(new File("file.json"), this);
            Integer temp = this.size();
            writer.write(temp + "");
            System.out.println("То, что пишется в файл: " + this.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> readToJSONFile() {
        ArrayList<User> returnList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        Integer sizeMass = null;

        try (FileReader reader = new FileReader("sizeMass")){
             sizeMass = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[] userArray = null;
        try {
            userArray = mapper.readValue(new File("file.json"), Object[].class);
        } catch (JsonParseException e) {
            System.out.println("Я то самое неверное исключение?");
            e.printStackTrace();
        } catch (JsonMappingException e) {
            System.out.println("Я то самое неверное исключение22222?");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.asList(userArray).forEach(el -> {
            if (((LinkedHashMap<Object, Object>) el).containsKey("lang")) {
                returnList.add(new Developer(
                        ((LinkedHashMap<Object, Object>) el).get("name").toString(),
                        Integer.parseInt(((LinkedHashMap<Object, Object>) el).get("phone").toString()),
                        Short.parseShort(((LinkedHashMap<Object, Object>) el).get("id").toString()),
                        (ArrayList<String>) ((LinkedHashMap<Object, Object>) el).get("lang")
                ));
            } else {
                returnList.add(new Manager(
                        ((LinkedHashMap<Object, Object>) el).get("name").toString(),
                        Integer.parseInt(((LinkedHashMap<Object, Object>) el).get("phone").toString()),
                        Short.parseShort(((LinkedHashMap<Object, Object>) el).get("id").toString())
                ));
            }
        });

        return returnList;
    }

}

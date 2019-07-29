package ru.eltex;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Developer extends User implements CSV {
    ArrayList<String> lang;

    public Developer(String name, Integer phone, Short id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.lang = new ArrayList<>();
    }

    public Developer(@JsonProperty(value = "name")String name, @JsonProperty(value = "phone") Integer phone, @JsonProperty(value = "id") Short id, @JsonProperty(value = "lang") ArrayList<String> lang) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.lang = lang;
    }

    public void setLang(ArrayList<String> lang) {
        this.lang = lang;
    }

    public ArrayList<String> getLang() {
        return lang;
    }

    public void addLang(String... args) {
        for (String str : args) {
            lang.add(str);
        }
    }
}

package ru.eltex;

import java.util.ArrayList;

public class Developer extends User implements CSV {
    ArrayList<String> lang;

    public Developer(String name, Integer phone, Short id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        lang = new ArrayList<>();
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

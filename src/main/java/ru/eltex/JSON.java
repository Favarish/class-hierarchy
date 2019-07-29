package ru.eltex;

import java.util.ArrayList;

public interface JSON {
    void writeToJSON();

    ArrayList<User> readToJSONFile();
}

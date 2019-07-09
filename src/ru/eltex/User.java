package ru.eltex;

public abstract class  User implements Comparable<User>{
    String name;
    Integer phone;
    Short id;


    public Integer getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public boolean equals(User other) {
        return this.name.equals(other.name);
    }

    public int compareTo(User other) {
        return this.id.compareTo(other.id);
    }
}

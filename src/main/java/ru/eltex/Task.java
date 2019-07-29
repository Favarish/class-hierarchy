package ru.eltex;

public class Task<T extends User, V extends User> {
    private T сhief;
    private V subordinate;

    private String description;


    public Task(T сhief, V subordinate) {
        this.сhief = сhief;
        this.subordinate = subordinate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void printTask() {
        String[] class1 = this.сhief.getClass().toString().split("\\.");
        String[] class2 = this.subordinate.getClass().toString().split("\\.");

        System.out.println("Начальник: " + class1[2] + " " + this.сhief.getName() + "; Подчиненный: " + class2[2] + " " + this.subordinate.getName());
        System.out.println("Краткая информация о задаче: \n" + description);
    }
}

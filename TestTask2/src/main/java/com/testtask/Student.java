package com.testtask;

public class Student {
    String name;

    int id;
    String surname;
    String patronymic;
    String group;
    String date;
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getGroup() {
        return group;
    }

    public String getDate() {
        return date;
    }

    public Student(int id, String name, String surname, String patronymic, String date,String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.date = date;
        this.group = group;
    }
}

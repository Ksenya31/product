package ru.netology.domain;
public class Product {
    protected String name; //Protected - Дает доступ всем из того же самого пакета + НАСЛЕДНИКАМ.
    protected int id;
    protected int cost; //Стоимость.

    public Product(String name, int id, int cost) { //<-Конструктор.
        this.name = name;
        this.id = id;
        this.cost = cost;
    }


    public boolean matches(String query) {
        if (name.contains(query)) { //Если имя содержит(запрос).
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }
}


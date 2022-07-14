package ru.netology.domain;
public abstract class Product {
    protected String name;
    protected int id;
    protected int cost;

    public Product(String name, int id, int cost) { //<-Конструктор.
        this.name = name;
        this.id = id;
        this.cost = cost;
    }

        public int getId() {
        return id;
    }


    public boolean matches(String query) {
        if (name.contains(query)) { //Если имя содержит(запрос).
            return true;
        } else {
            return false;
        }
    }
}




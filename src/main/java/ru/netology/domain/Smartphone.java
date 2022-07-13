package ru.netology.domain;
import ru.netology.domain.Product;

public class Smartphone extends Product {

    public String producer;

    public Smartphone(String name, int id, int cost, String producer) {
        super(name, id, cost);
        this.producer = producer;
    }

    @Override
    public boolean matches(String query) {
        if (super.matches(query)) {
            return true;
        }
        if (producer.contains(query)) {
            return true;
        }
        return false;
    }
}

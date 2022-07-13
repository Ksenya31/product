package ru.netology.domain;

public class Book extends Product { // extends - Расширяет. Скопирует все с Product в Book.

    public String author;

    public Book(String name, int id, int cost, String author) { //<-Конструктор.
        super(name, id, cost);// Вызывай конструктор моего отца с параметрами (.......).
        this.author = author;
    }

    @Override
    public boolean matches(String query) {
        /*if (name.contains(query)) {
            return true;
        }*/
        if (super.matches(query)) { //super. - Вызови методв в версии которая мне пришла в наследство.
            return true;
        }

        if (author.contains(query)) {
            return true;
        }
        return false;
    }


}
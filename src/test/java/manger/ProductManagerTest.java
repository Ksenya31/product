package manger;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Book book1 = new Book("Властелин колец", 505, 250, "Дж.Р.Р.Толкин");
    Book book2 = new Book("Хоббит", 510, 400, "Дж.Р.Р.Толкин");
    Smartphone smartphone1 = new Smartphone("Груша", 20, 500, "Яблочный Стив");
    Smartphone smartphone2 = new Smartphone("Игровая подстанция 5", 60, 300, "Кони");

    @Test
    public void test1ShouldFindElements() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ин");
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2ShouldFindElements() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ша");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3ShouldFindElements() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ни");
        Product[] expected = {smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4ShouldFindElements() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ив");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test5ShouldFindElements() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("а");
        Product[] expected = {book1, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test6ShouldFindElements() {
        ProductManager manager = new ProductManager();
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("яя");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}
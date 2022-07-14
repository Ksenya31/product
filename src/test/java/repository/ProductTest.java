package repository;

import org.junit.jupiter.api.Test;
import ru.netology.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    ProductManager manager = new ProductManager();
    ProductRepository repo = new ProductRepository();
    Book book1 = new Book("Властелин колец", 505, 250, "Дж.Р.Р.Толкин");
    Book book2 = new Book("Хоббит", 510, 400, "Дж.Р.Р.Толкин");
    Smartphone smartphone1 = new Smartphone("Груша", 20, 500, "Яблочный Стив");
    Smartphone smartphone2 = new Smartphone("Игровая подстанция 5", 60, 300, "Кони");

      @Test
    public void FindAll() {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void Remove() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(505);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void test1Find() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ин");
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void test2Find() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("сон");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3Find() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("ив");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4Find() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("а");
        Product[] expected = {book1, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void test5Find() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.findByQuery("яя");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}



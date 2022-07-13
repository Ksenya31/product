package repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Book book1 = new Book("Властелин колец", 505, 250, "Дж.Р.Р.Толкин");
    Book book2 = new Book("Хоббит", 510, 400, "Дж.Р.Р.Толкин");
    Smartphone smartphone1 = new Smartphone("Груша", 20, 500, "Яблочный Стив");
    Smartphone smartphone2 = new Smartphone("Игровая подстанция 5", 60, 300, "Кони");

    @Test
    void test1ProductRepositoryRemove() {
        ProductRepository repo = new ProductRepository(); // Подготовительное действие.
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(505); //Тестируемое действие.

        Product[] actual = repo.findAll();
        Product[] expected = {book2, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test2ProductRepositoryRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(510);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test3ProductRepositoryRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(20);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test4ProductRepositoryRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(60);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test5ProductRepositoryRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(60);
        repo.removeById(20);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test6ProductRepositoryRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        repo.removeById(505);
        repo.removeById(510);
        repo.removeById(20);
        repo.removeById(60);

        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test7ProductRepositoryRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);


        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void test8ProductRepositoryFindById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }

    @Test
    void test9ProductRepositoryFindById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(504);
        });
    }

}

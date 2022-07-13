package ru.netology.manager;

import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;

public class ProductManager {
    private Product[] subject = new Product[0];

    public void add(Product product) { //Метод добавления.
        Product[] tmp = new Product[subject.length + 1];
        for (int i = 0; i < subject.length; i++) {
            tmp[i] = subject[i];
        }
        tmp[tmp.length - 1] = product;
        subject = tmp;
    }

    public Product[] findByQuery(String queary) { //Метод поиска.
        Product[] result = new Product[0];

        for (Product product : subject) {
            if (product.matches(queary)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}

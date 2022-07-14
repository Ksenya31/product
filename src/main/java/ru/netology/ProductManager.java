package ru.netology;

import ru.netology.ProductRepository;
import ru.netology.Product;

public class ProductManager {
    private Product[] subject = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[subject.length + 1];
        for (int i = 0; i < subject.length; i++) {
            tmp[i] = subject[i];
        }
        tmp[tmp.length - 1] = product;
        subject = tmp;
    }

    public Product[] findByQuery(String text) {
        Product[] result = new Product[0];

        for (Product product : subject) {
            if (product.matches(text)) {
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
package ru.nethology.manager;

import org.junit.jupiter.api.Test;
import ru.nethology.domain.Book;
import ru.nethology.domain.Product;
import ru.nethology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    Book first = new Book(1, "Book1", 900, "Belov");
    Book second = new Book(2, "Book2", 200, "Elov");
    Book third = new Book(3, "Book3", 500, "Golov");


    @Test
    public void shouldLookForABook() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.searchBy("Book2");

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Book2");

        assertArrayEquals(expected, actual);
    }


}
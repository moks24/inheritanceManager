package ru.nethology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nethology.domain.Book;
import ru.nethology.domain.Product;
import ru.nethology.domain.Smartphone;
import ru.nethology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    Book first = new Book(1, "Book1", 900, "Belov");
    Book second = new Book(2, "Book2", 200, "Elov");
    Book third = new Book(3, "Book3", 500, "Golov");
    Smartphone fourth = new Smartphone(4,"Nokia", 9900, "Russia");
    Smartphone fifth = new Smartphone(5,"Nokia", 11300, "Finland");
    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldLookForABook() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Book2");

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldLookForABookByAuthor() {
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Golov");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLookForASmartphone() {
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Nokia");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Gusev");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void severalGoods() {
        Product[] expected = new Product[]{fourth, fifth};
        Product[] actual = manager.searchBy("Nokia");

        assertArrayEquals(expected, actual);
    }
}
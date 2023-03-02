package com.example.bookstore;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createNewBook() {
        Book book = new Book("Test Book", "Test Author", 2022, "1234567890", 9.99,
                categoryRepository.findByName("Novel").get(0));
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        Optional<Book> book = repository.findById(1L);
        assertThat(book).isNotEmpty();

        repository.deleteById(1L);

        Optional<Book> deletedBook = repository.findById(1L);
        assertThat(deletedBook).isEmpty();
    }

    @Test
    public void findBookByTitle() {
        List<Book> books = repository.findByTitle("To Kill a Mockingbird");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Harper Lee");
    }
}


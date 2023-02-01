package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {return (args) -> {
		Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780446310789", 12.99);
		Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", 14.99);
		Book book3 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "9780544003415", 19.99);
		
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
	};
	}
}

package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("Novel"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Comic"));

			brepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780446310789", 12.99,
					crepository.findByName("Novel").get(0)));
			brepository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", 14.99,
					crepository.findByName("Comic").get(0)));
			brepository.save(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "9780544003415", 19.99,
					crepository.findByName("Fiction").get(0)));
		};
	}
}

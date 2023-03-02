package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerSmokeTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void bookListShouldReturnOk() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/booklist",
				String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void addBookShouldReturnOk() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/addbook",
				String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void booksRestShouldReturnOk() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/books",
				String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}

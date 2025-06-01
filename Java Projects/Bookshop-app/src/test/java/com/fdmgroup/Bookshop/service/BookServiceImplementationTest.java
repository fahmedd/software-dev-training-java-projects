package com.fdmgroup.Bookshop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroup.Bookshop.model.Book;
import com.fdmgroup.Bookshop.repository.BookRepository;


@ExtendWith(MockitoExtension.class) // to create mockito environment
class BookServiceImpTest {
	
	@InjectMocks
	BookServiceImplementation bookService; //class testing but will give the class mock objects
	// so inject mock objects

	@Mock //mockBean
	BookRepository bookRepository;

	Book book;

	@BeforeEach
	void setup() {
		book = new Book();
		book.setTitle("Introduction to Junit");
		book.setAuthor("John Doe");
		book.setPrice(BigDecimal.valueOf(9.99));
	}

	@Test
	@DisplayName("Create Book")
	void givenBook_whenSave_thenReturnSavedBookFromDatabase() {
		// arrange- mock object
		when(bookRepository.save(book)).thenReturn(book);
		//when create method is called, book must be saved first
		// act- method in Book service
		Book actual = bookService.createBook(book);

		// assert
		assertThat(actual).isNotNull();
		assertThat(actual.getAuthor()).isEqualTo("John Doe");
		assertThat(actual.getTitle()).isEqualTo("Introduction to Junit");
		verify(bookRepository, times(1)).save(book); //must verify to make it a valid mockito test
	}

	@Test
	@DisplayName("Find book by id")
	void givenBookId_whenFindBookById_thenReturnDBBook() {
		// arrange- mock the repository
		Long id = 1L;
		when(bookRepository.findById(id)).thenReturn(Optional.of(book));

		// act
		Book actual = bookService.findBookById(id);

		// assert
		assertThat(actual).isNotNull();
		assertThat(actual.getAuthor()).isEqualTo("John Doe");
		assertThat(actual.getTitle()).isEqualTo("Introduction to Junit");
		assertThat(actual.getPrice()).isEqualTo(BigDecimal.valueOf(9.99));
		verify(bookRepository, times(1)).findById(id);
	}

	@Test
	void givenBook_whenFindAll_thenReturnBookList() {
		// arrange- created books and added books to a dblist
		Book book2 = new Book();
		book2.setAuthor("James Smith");
		book2.setPrice(BigDecimal.valueOf(12.99));
		book2.setTitle("Introduction to Spring");

		List<Book> books = List.of(book, book2);
		Iterable<Book> dbBooks = books;
		//when the method is called use the made up dbbooks
		when(bookRepository.findAll()).thenReturn(dbBooks);

		// act- call on the method
		Iterable<Book> actual = bookService.findAllBooks();

		// assert- stream seperate ones
		assertThat(StreamSupport.stream(actual.spliterator(), false).count()).isEqualTo(2);
		verify(bookRepository, times(1)).findAll();

	}

	@AfterEach
	void tearDown() {
		bookService = null;
		bookRepository = null;
		book = null;
	}

}

package com.fdmgroup.Bookshop.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.fdmgroup.Bookshop.model.Book;

@ActiveProfiles({"test","dev"})
@DataJpaTest
class BookRepositoryTest {

	@Autowired
	//class we are testing
	private BookRepository bookRepository;
	Book book;
	
	@BeforeEach //each test should be isolated from eachother
	void setup() {
		//System.err.println("setup");
		
		//arranging book object before each class
		book = new Book();
		book.setAuthor("John dow");
		book.setTitle("introduction");
		book.setPrice(BigDecimal.valueOf(12.99));
	
	
	}
	
	@Test
	@DisplayName("Test JPA save method")
	void given_BookOject_whenExecuteSave_thenReturnNumberOfBooks() {
		//System.err.println();
		
		//acting- using the method- using the objetc created for the tests
		bookRepository.save(book);
		
		Assertions.assertThat(bookRepository.count()).isEqualTo(1); // this will check how many books are in the database- checks if been saved successfully
		// counts how many books- should fail as we only have 1 book
		}

	@Test
	@DisplayName("Test JPA findbyId method")
	void given_then(){
		
		////arrange- saving book needs to happen before you can execute the method
		bookRepository.save(book);
		
		//act- do the method- 1L(signifies long value)
		Optional<Book> actual = bookRepository.findById(1L);
		
		//assert- ensuring the book exists and its not a null object
		Assertions.assertThat(actual).isNotNull();
		// can use assertEquals instead
		Assertions.assertThat(bookRepository.count()).isEqualTo(1); //counts how many
		
		//check the correct title is called
		assertThat(actual.get().getTitle()).isEqualTo("introduction");
		//not working
	}
	
	
	@Test
	@DisplayName("Find all books")
	void givenABook_WhenFindAll_thenReturnListOfBooks(){
		//arrange- saving book needs to happen before you can execute the method
		bookRepository.save(book);
		
		//act
		//casting to arraylist
		ArrayList<Book> actual = (ArrayList<Book>) bookRepository.findAll();
		//List is a child of iterable- 
		//iterable doesnt inherit from a collection 
		//Iterable<book> actual= bookRepository.findAll();
	
		
		assertThat(actual.size()).isEqualTo(1);
		//dont need assertions. once you make the import static
		//assertThat(StreamSupport.stream(actual.spliterator().false).count()).isEqualTo(1);
		//stream it (Streams) out and count 1 by 1 and see if its equal to one
	}
	
	
	
	@Test
	@DisplayName("Delete book by title")
	void givenBook_whenExecuteDeleteByTitle_thenDeleteTheBook(){
		//arrange- saving book needs to happen before you can execute the method
		bookRepository.save(book);
		
		//act- delete methods are void methods
		bookRepository.deleteByTitle(book.getTitle());
		
		assertThat(bookRepository.count()).isEqualTo(0);
	}
	
	
	
	
	// used to delete
	@AfterEach
	void tearDown() {
		bookRepository.deleteAll();// ensures database is empty before each test case
		//new environment before each test
		//System.err.println();
		bookRepository= null; // to clean up environment in the virtual machine - using garbage collecter
		//garbage collecter will clean anything in stack initialised to null or something not used for a while
		book= null; 
	}
	
	
}

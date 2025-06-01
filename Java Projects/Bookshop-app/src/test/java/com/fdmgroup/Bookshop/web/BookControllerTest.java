package com.fdmgroup.Bookshop.web;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;

import static org.mockito.BDDMockito.given;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.Bookshop.model.Book;
import com.fdmgroup.Bookshop.service.BookServiceImplementation;

@WebMvcTest(BookController.class) // what class we are testign
class BookControllerTest {

	@Autowired
	MockMvc mockMvc;
	//acts like the postman- mapping

	@MockBean //spring framework
	BookServiceImplementation bookService;

	@Autowired
	ObjectMapper objectMapper;
	//objectmapper- will convert the object to a json object - 
		//for when doing mvc as mvc needs json
		// controller testing - we need mvc and that requires a json file
	// so that the book can be saved
	
	//will be converted to json object by object mapper
	Book book;

	@BeforeEach
	void setup() {
		book = new Book();
		book.setTitle("Introduction to Junit");
		book.setAuthor("John Doe");
		book.setPrice(BigDecimal.valueOf(9.99));
	}

	@Test
	@DisplayName("Find All Books")
	void givenNothing_whenFindAll_thenReturnsAllBooks() throws Exception {
		// arrange
		Iterable<Book> dbBooks = List.of(book);
		Mockito.when(bookService.findAllBooks()).thenReturn(dbBooks);

		// assert - perform a get request- then add the address
		//@formatter:off  - to stop it being formatted into 1 line and keeps it the same indenting
		mockMvc.perform(get("/api/v1/books"))
			.andExpect(status().isOk())// expecting ststus from the og method
			.andExpect(jsonPath("$", Matchers.hasSize(1))) //$ means all the books
			.andExpect(jsonPath("$[0].title", is("Introduction to Junit"))); //$[0]- on the first book in the list
		// @formatter:on

	}

	@Test
	@DisplayName("saveBook")
	void givenbook_whensaveBook_thenReturnSavedBook() throws Exception {
		//set the id and isbn - when comes back from db all these fields will be setup
		book.setId(1L);
		book.setIsbn(UUID.randomUUID().toString());
		book.setPublishDate(LocalDate.now());

		//arrange- when the method is called - input the mock book
		//Mockito.when(bookService.createBook(book)).thenReturn(book);

		
		//behavioral driven development mockito
		given(bookService.createBook(ArgumentMatchers.any(Book.class)))
		.willAnswer(invocation -> invocation.getArgument(0));
		// when I pass in a valid book return me the same book
		
		// assert- // go to this address and perform post task- will be given json file
		//the book object will be converted to json object
		//@formatter:off
		//perform post - and will get JSON files
		mockMvc.perform(post("/api/v1/books")
				//.accept(MediaType.APPLICATION_JSON)// accept a json objecy
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(book))) // convert the book object to a json object
				.andDo(print())
				.andExpect(status().isCreated()) //Checks the ststus is the same as a method- if static then can remove mockmvmatchers
				.andExpect(jsonPath("$.title", is(book.getTitle()))) //compares if theyre the same book
				.andExpect(jsonPath("$.author", is(book.getAuthor())))
				.andExpect(jsonPath("$.price", is(book.getPrice()),BigDecimal.class))
		.andExpect(jsonPath("$.isbn",is(book.getIsbn())));
		//.andExpect(mockMvcMatchers.jsonPath($.title", CoreMatchers. is...
		//@formatter:off
	//$object

	}
	
	@Test
	@DisplayName("Find book by id")
	void givenBookId_whenFindById_thenReturnSavedBookInDB() throws Exception {
	
		book.setId(1L);
		book.setIsbn(UUID.randomUUID().toString());
		book.setPublishDate(LocalDate.now());
	
		when(bookService.findBookById(1L)).thenReturn(book);
	
		//BDDMockito.given(bookService.findBookById(1L)).willreturn(book);
		
		mockMvc.perform(get("/api/v1/books/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(book)))
				.andDo(print())
				.andExpect(jsonPath("$.title", is(book.getTitle())))
				.andExpect(jsonPath("$.author", is(book.getAuthor())))
				.andExpect(jsonPath("$.price", is(book.getPrice()),BigDecimal.class))
				.andExpect(jsonPath("$.isbn", is(book.getIsbn())));
		///books/1 is path variable
	}
	
	
	@Test
	@DisplayName("Delete book by title")
	void givenBookTitle_whenDeleteByTitle_thenDeleteBookInDB() throws Exception {
	
		BDDMockito.willDoNothing().given(bookService).deleteBookByTitle("Introduction to Junit");;
		//dont do anything no return as its a void method
		
		mockMvc.perform(delete("/api/v1/books/Introduction to Junit"))
		.andDo(print())
		.andExpect(status().isOk());
		
		
		
	}
	
	
	

	@AfterEach
	void tearDown() {
		book = null;
		objectMapper= null;
		bookService=null;
		mockMvc= null;
	}

}


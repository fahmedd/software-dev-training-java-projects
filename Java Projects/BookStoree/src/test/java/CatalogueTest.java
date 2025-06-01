import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Bookstore.Book;
import Bookstore.Catalogue;
import Bookstore.ReadItemCommand;
import Bookstore.WriteItemCommand;



@ExtendWith(MockitoExtension.class) 
public class CatalogueTest {
	
	
	Catalogue catalogue;
	ArrayList<Book> booklist1;
	
	
	@Mock
	ReadItemCommand MockReadcommand1;
	@Mock
	WriteItemCommand MockWritecommand;
	@Mock
	Book Mockbook1; 
	@Mock
	Book Mockbook2; 
	@Mock
	Book Mockbook3; 
	@Mock
	Book Mockbook4; 
	@Mock
	Book Mockbook5;
	
	
	
	@BeforeEach
	public void test_setup(){
	booklist1= new ArrayList<Book>();
	catalogue= new Catalogue(MockReadcommand1, MockWritecommand, booklist1);
	}

	@Test
	public void getAllBooksFroomCatalogue_ReturnEmptyListWhenItIsAnEmptyList(){
		booklist1.addAll(catalogue.getAllBooks());
		int booklistSize= booklist1.size();
		assertEquals(0,booklistSize);
	}
	
	@Test //2 
	public void getAllBooks_ShouldCallReadAllMethodOfReadItemCommand() {
		catalogue.getAllBooks();
		verify(MockReadcommand1,times(1)).readAll();
		
	}
	
	@Test // 3
	public void getAllBooksMethod_returnsListOfBooksRecievedFromReadAllMethod_WhenCalled() {
		when(MockReadcommand1.readAll()).thenReturn(booklist1);
		
		booklist1.add(Mockbook1);
		booklist1.add(Mockbook2);
		booklist1.add(Mockbook3);
		booklist1.add(Mockbook4);
		booklist1.add(Mockbook5);
		
		ArrayList<Book> listofBooks= catalogue.getAllBooks();

		assertEquals(booklist1,listofBooks);
		
	}
	
	@Test //4
	public void test_addBookMethodPassessBookAdded_ToTheInsertItemMethodOfWriteItemCommand() {
		catalogue.addBook(Mockbook1);
		verify(MockWritecommand,times(1)).insertItem(Mockbook1);
		
	}
	
	@Test //5 
	public void test_addBooksMethodPassessBooksAdded_ToTheInsertItemMethodOfWriteItemCommand() {
		booklist1.add(Mockbook1);
		booklist1.add(Mockbook2);
		booklist1.add(Mockbook3);
		booklist1.add(Mockbook4);
		booklist1.add(Mockbook5);
		
		catalogue.addBooks(booklist1);
//		verify(MockWritecommand,times(1)).insertItem(Mockbook1);
//		verify(MockWritecommand,times(1)).insertItem(Mockbook2);
//		verify(MockWritecommand,times(1)).insertItem(Mockbook3);
//		verify(MockWritecommand,times(1)).insertItem(Mockbook4);
//		verify(MockWritecommand,times(1)).insertItem(Mockbook1);
		//Can do it this way
		verify(MockWritecommand,times(5)).insertItem(any(Book.class));
		
	}
	
	@Test //6
	public void test_getBookReturnsBookWithSameISBNValueAsOneSet_fromReadItemCommandsGetItemMethod() {
		when(MockReadcommand1.getItem("5000")).thenReturn(Mockbook1);
		when(Mockbook1.getISBN()).thenReturn("5000");
		//catalogue.getBook("5000");
		//verify(MockReadcommand1,times(1)).getItem("5000");
		Book bookISBN= catalogue.getBook("5000");
		assertEquals("5000",bookISBN.getISBN());
		
	}
	
	@Test //7
	public void test_deleteBookMethodTakesBookArgument_PassBookToWriteItemCommandsDeleteItemMethod() {
		
		catalogue.deleteBook(Mockbook2);
		verify(MockWritecommand,times(1)).deleteItem(Mockbook2);
		;
	}
	
	@Test //8
	public void test_deleteAllBooksMethod_CallsReadItemCommandsReadAllMethod_ThenCallWriteItemCommandsDeleteItemMethodOnceForEachBookReturnedByReadAllMethod() {
		booklist1.add(Mockbook1);
		booklist1.add(Mockbook2);
		booklist1.add(Mockbook3);
		booklist1.add(Mockbook4);
		booklist1.add(Mockbook5);
		
		when(MockReadcommand1.readAll()).thenReturn(booklist1);
		catalogue.addBooks(booklist1);
			
		catalogue.deleteAllBooks();
		 
		 verify(MockReadcommand1,times(1)).readAll();
//		 verify(MockWritecommand,times(1)).deleteItem(Mockbook1);
//		 verify(MockWritecommand,times(1)).deleteItem(Mockbook2);
//		 verify(MockWritecommand,times(1)).deleteItem(Mockbook3);
//		 verify(MockWritecommand,times(1)).deleteItem(Mockbook4);
//		 verify(MockWritecommand,times(1)).deleteItem(Mockbook5);
		 //Can do
		 verify(MockWritecommand, times(5)).deleteItem(any(Book.class));
	}
	
}

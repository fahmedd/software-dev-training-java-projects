package Bookstore;

public interface WriteItemCommand {

	public void insertItem(Book book);
	
	public void deleteItem(Book book);
}

package client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Books {
	private Collection<Book> books= new ArrayList<Book>();
	

	public Books() {
	}

	public Books(Collection<Book> books) {
		this.books = books;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
		
}

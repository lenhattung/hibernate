package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	private String book_id;
	private String title;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;

	public Book() {
	}

	public Book(String book_id, String title, double price, Author author) {
		this.book_id = book_id;
		this.title = title;
		this.price = price;
		this.author = author;
	}



	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	
}

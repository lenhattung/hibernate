package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	
	@Id
	private String author_id;
	private String name;
	private Date dateOfBirth;
	
	public Author() {
	}

	public Author(String author_id, String name, Date dateOfBirth) {
		this.author_id = author_id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}

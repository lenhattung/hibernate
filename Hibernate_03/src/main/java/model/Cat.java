package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Cat {
	private Integer id;
	private String name;
	private Date dateOfBirth;
	private Boolean sex;
	
	// Bat buoc mot constructor rong
	public Cat() {
	}

	public Cat(String name, Date dateOfBirth, Boolean sex) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
	}

	@Id // Khoa chinh
	@GeneratedValue // Tu dong tang, auto number
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + "]";
	}
	
}

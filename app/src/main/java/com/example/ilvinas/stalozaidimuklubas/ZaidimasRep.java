package com.example.ilvinas.stalozaidimuklubas;

public class ZaidimasRep {
	private int id;
	private String date;
	private String title;
	private String cats;
	private int year;
	private String author;
	private String publisher;
	private String owner;
	private String holder;
	
	public ZaidimasRep() {
	}

	public ZaidimasRep(String date, String title, String cats, int year, String author, String publisher, String owner,
			String holder) {
		super();
		this.date = date;
		this.title = title;
		this.cats = cats;
		this.year = year;
		this.author = author;
		this.publisher = publisher;
		this.owner = owner;
		this.holder = holder;
	}

	public ZaidimasRep(int id, String date, String title, String cats, int year, String author, String publisher,
			String owner, String holder) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.cats = cats;
		this.year = year;
		this.author = author;
		this.publisher = publisher;
		this.owner = owner;
		this.holder = holder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCats() {
		return cats;
	}

	public void setCats(String cats) {
		this.cats = cats;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}
	
}

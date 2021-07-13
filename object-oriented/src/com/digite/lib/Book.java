package com.digite.lib;

public class Book {
	private String title;
	private Member mbr;
	
	public Book() {
	}

	public Book(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public void status() {
		if(mbr == null)
			System.out.println(title +" is not issued to any member");
		else
			System.out.println(title + " is issued to " + mbr.getName());
	}
	
	public void issueBook(Member m) {
		if(mbr != null)
			System.out.println(title +" is already issued to " + mbr.getName());
		else if(m.getBook() != null)
			System.out.println(m.getName() + " has already issued a book");
		else {
			this.mbr = m;
			m.setBook(this);
		}
	}
	
	public void returnBook(Member m) {
		if(mbr == null)
			System.out.println(title + " is never issued");
		else if(m.getBook() == null)
			System.out.println(m.getName() + " has never issed a book");
		else if(!m.getName().equals(mbr.getName()))
			System.out.println(title + " is not issue to " + m.getName());
		else {
			this.mbr = null;
			m.setBook(null);
		}
	}
}

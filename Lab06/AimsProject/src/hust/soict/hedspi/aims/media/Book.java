package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media{
	private ArrayList<String> authors = new ArrayList<String>();
	
	public ArrayList<String> getAuthors(){
		return authors;
	}
	
	public void setAuthor(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	public Book(int id, String title) {
		super(id, title);
	}
	
	public Book(int id, String title, String category) {
		super(id, title, category);
	}
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
		super(id, title, category, cost);
		if(authors.size() == 0 ) {
			System.out.println();
		}
	}
	
	public void addAuthor(String authorName) {
		for(String author: authors) {
			if(author.equals(authorName)) {
				System.out.println("This name is exists!");
				System.exit(0);
			}
		}
		authors.add(authorName);
		System.out.println("Add author " + authorName + " successfull!");
	}
	
	public void removeAuthor(String authorName) {
		for(String author: authors) {
			if(author.equals(authorName)) {
				authors.remove(author);
				System.out.println("Delete " + author + " complete!");
				System.exit(0);
			}
		}
		System.out.println(authorName + " Not found!");
	}
	
	@Override
    public String toString(){
        return "Book - " + super.getTitle() + " - " + super.getCategory() + " - Author : " + authors.toString() + " - " + super.getCost() + "$";
    }
}

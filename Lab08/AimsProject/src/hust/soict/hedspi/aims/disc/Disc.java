package hust.soict.hedspi.aims.disc;
import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media{
	protected String director;
	protected int length;
	
	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	public Disc(int id, String category, float cost) {
		super(id, category, cost);
	}
	
	public Disc(int id, String title, String category) {
		super(id, title, category);
	}
	
	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public Disc(int id, String title, String category, int length, float cost) {
		super(id, title, category, cost);
		this.length = length;
	}
	
	public Disc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}
}

package hust.soict.hedspi.aims.media;

public class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public float getCost() {
		return cost;
	}
	
	public Media(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Media(int id, String category, float cost) {
		this.id = id;
		this.category = category;
		this.cost = cost;
	}
	
	public Media(int id, String title, String category) {
		this.id = id;
		this.title = title;
		this.category = category;
	}
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
}

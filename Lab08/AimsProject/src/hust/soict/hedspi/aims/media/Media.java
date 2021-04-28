package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.disc.*;

public abstract class Media implements Comparable<Media>{
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
	
	public boolean equals(Object object) {
		Media m = (Media) object;
		if(id == m.id) {
			return true;
		}
		return false;
	}
	
	public int compareTo(Media media) {
		if (this instanceof Book && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
            return -1;
        }
        if(this instanceof DigitalVideoDisc && media instanceof CompactDisc)
            return -1;
        if(this instanceof CompactDisc && (media instanceof DigitalVideoDisc || media instanceof Book))
            return 1;
        if(this instanceof DigitalVideoDisc && media instanceof Book)
            return 1;
        return 0;
	}
}

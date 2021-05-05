package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.*;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
	
//    public DigitalVideoDisc() {
//    	super();
//    }
    
	public DigitalVideoDisc(int id, String title, String category) {
		super(id, title, category);
	}
	
	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public DigitalVideoDisc(int id, String title, String category, int length, float cost) {
		super(id, title, category, length, cost);
	}

	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
	}
	
	@Override
    public String toString(){
        return "DVD - " + super.getTitle() + " - " + super.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + super.getCost() + "$";
    }
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public int compareTo(Media media) {
		if(media instanceof DigitalVideoDisc) {
			if(this.getCost() < media.getCost()) {
				return -1;
			} else if(this.getCost() == media.getCost()) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return super.compareTo(media);
		}
	}
	
}

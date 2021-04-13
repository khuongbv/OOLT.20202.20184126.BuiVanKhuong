package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc extends Disc implements Playable{
	
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
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
}

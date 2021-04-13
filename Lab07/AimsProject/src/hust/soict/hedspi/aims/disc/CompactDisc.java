package hust.soict.hedspi.aims.disc;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public CompactDisc(int id, String title, String category, String artist, float cost) {
		super(id, title, category, cost);
		this.artist = artist;
	}
		
	public CompactDisc(int id, String category, String artist, float cost) {
		super(id, category, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("This track already exists");
		} else {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Remove track successfull");
		} else {
			System.out.println("This track does not exist");
		}
	}
	
	public int getLength() {
		int length_sum = 0;
		for(Track t: tracks) {
			length_sum += t.getLength();
		}
		super.length = length_sum;
		return length_sum;
	}
	
	@Override
    public String toString(){
        return "CD - " + super.getTitle() + " - " + super.getCategory() + " - " + this.getLength() + " : " + super.getCost() + "$";
    }
	
	@Override
	public void play() {
		for(Track t: tracks) {
			System.out.println("Playing CD: " + t.getTitle());
			System.out.println("CD length: " + t.getLength());
		}
	}
}

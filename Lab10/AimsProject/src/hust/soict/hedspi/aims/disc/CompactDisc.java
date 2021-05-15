package hust.soict.hedspi.aims.disc;


import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import hust.soict.hedspi.aims.exception.*;
public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	public String message;
	
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
	
	public void play() throws PlayerException {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		this.message = "Playing CD: " + this.getTitle() + " CD length: " + this.getLength();
		if(this.getLength() > 0) {
			for(Track t: tracks) {
				t.play();
				message = "Playing Track: " + t.getTitle() + "\nTrack length: " + t.getLength();
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
		
	}
	
	public int compareTo(Media media) {
		if(media instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc) media;
			if(tracks.size() == cd.tracks.size()) {
                return Integer.compare(this.length, cd.getLength());
            }
            else if(tracks.size() < cd.tracks.size())
                return -1;
            else return 1;
		} else {
            return super.compareTo(media);
        }
	}

	public ArrayList<Track> getTracks() {
        return tracks;
    }
}

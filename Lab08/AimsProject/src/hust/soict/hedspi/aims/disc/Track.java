package hust.soict.hedspi.aims.disc;

public class Track implements Playable, Comparable<Track>{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Track(int length, String title) {
		this.length = length;
		this.title = title;
	}
	
	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	public boolean equals(Object object) {
		Track t = (Track) object;
		if(title.equalsIgnoreCase(t.title) && length == t.length) {
			return true;
		}
		return false;
	}
	
	public int compareTo(Track track) {
		if(this.title.compareToIgnoreCase(track.title) < 0) {
			return -1;
		} else if (this.title.compareToIgnoreCase(track.title) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
}

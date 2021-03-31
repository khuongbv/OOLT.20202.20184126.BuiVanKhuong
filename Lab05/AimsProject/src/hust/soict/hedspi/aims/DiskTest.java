package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.order.*;
public class DiskTest {
	public static void main(String[] args) {
		Order anOrder = new Order();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd1, dvd3);
		anOrder.printOrdered();
		
		System.out.println(dvd1.search("lion"));
		System.out.println(anOrder.search("The liOn"));
		System.out.println("Total cost: " + anOrder.totalCost());
		System.out.println("Lucky Item: " + anOrder.getALuckyItem().getTitle());
		System.out.println("Total cost: " + anOrder.totalCost());
	}
}

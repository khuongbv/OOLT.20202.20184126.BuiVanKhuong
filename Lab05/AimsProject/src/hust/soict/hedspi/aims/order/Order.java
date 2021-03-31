package hust.soict.hedspi.aims.order;
import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.utils.*;
public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private MyDate dateOrdered;
	
	public Order() {
		if(nbOrders >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is full, can't make any new order!");
		} else {
			dateOrdered = new MyDate();
			nbOrders++;
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("Add " + disc.getTitle() + " successfull");
		} else {
			System.out.println("The order is full, can't add anymore!");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc ...dvdList) {
		if(this.qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full");
			System.exit(0);
		}
		for(DigitalVideoDisc disc: dvdList) {
			if(qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("Add " + disc.getTitle() + " successfull");
			} else {
				System.out.println("The order is full, can't add anymore!");
				System.exit(0);
			}
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("Add " + dvd1.getTitle() + " successfull");
			if(qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemOrdered[qtyOrdered] = dvd2;
				qtyOrdered++;
				System.out.println("Add " + dvd2.getTitle() + " successfull");
			} else {
				System.out.println("The dvd " + dvd2.getTitle() + " could not be added!");
			}
		} else {
			System.out.println("The item quantity has reached its limit!");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean check = false;
		for(int i = 0; i < this.qtyOrdered; i++) {
			if(itemOrdered[i].getTitle().equals(disc.getTitle())) {
				for(int j = i; j < this.qtyOrdered; j++) {
					itemOrdered[j] = itemOrdered[j+1];
				}
				qtyOrdered--;
				check = true;
//				System.out.println("Remove " + disc.getTitle() + " successfull!");
			}
		}
		if(check == false) {
			System.out.println(disc.getTitle() + " Not found!");
		}
	}
	
	public float totalCost() {
		float total = 0;
		for(int i = 0; i < this.qtyOrdered; i++) {
			total += this.itemOrdered[i].getCost();		
		}
		return total;
	}

	public boolean search(String title) {
		title = title.toLowerCase();
		for (int i = 0; i < qtyOrdered; i++) {
			if(itemOrdered[i].getTitle().toLowerCase().contains(title)) {
				return true;
			}
		}
		return false;
	}
	
	public DigitalVideoDisc getALuckyItem() {
		int rand = (int)(Math.random() * MAX_LIMITED_ORDERS) + 1;
		DigitalVideoDisc luckyDVD = new DigitalVideoDisc(itemOrdered[rand].getTitle(), itemOrdered[rand].getCategory(), itemOrdered[rand].getDirector(), itemOrdered[rand].getLength(), itemOrdered[rand].getCost());
		System.out.println("Lucky number: " + rand);
		removeDigitalVideoDisc(itemOrdered[rand]);
		return luckyDVD;
	}
	
	public void printOrdered() {
		System.out.println("***********************Order***********************");
		dateOrdered.print();
		System.out.println("Item Ordered: ");
		for(int i = 0; i < this.qtyOrdered; i++) {
			System.out.println((i + 1) + ". "+ this.itemOrdered[i].getTitle() + " - " + this.itemOrdered[i].getCategory() 
								+ " - " + this.itemOrdered[i].getDirector() + " - " + this.itemOrdered[i].getLength()
								+ ": " + this.itemOrdered[i].getCost());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
}


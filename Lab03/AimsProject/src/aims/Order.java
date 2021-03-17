package aims;

public class Order {
public static final int MAX_NUMBERS_ORDERED = 10;
	
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc " + disc.getTitle() + " has been added!");
		} else {
			System.out.println("the order is full, can't add anymore!");
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
				System.out.println("Remove " + disc.getTitle() + " successfull!");
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
}

package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.MyDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;
	private MyDate dateOrdered;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(); 
	
	public Order() {
		if(nbOrders >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is full, can't make any new order!");
			System.exit(0);
		} else {
			dateOrdered = new MyDate();
			nbOrders++;
		}
	}
	
	public void addMedia(Media... mediasList) {
		for(int i = 0 ; i < mediasList.length; i++) {
			if(itemsOrdered.contains(mediasList[i])) {
				System.out.println(mediasList[i].getTitle() + " is existed");
			} else {
				itemsOrdered.add(mediasList[i]);
				System.out.println("Add " + mediasList[i].getTitle() + " successfull");
				
			}
		}
	}
	
	public void removeMedia(int id) {
		int check = 0;
		for(Media m: itemsOrdered) {
			if(m.getId() == id) {
				check = 1;
			}
		}
		if(check == 0) {
			System.out.println("Not found Media with id: " + id);
		} else {
			this.itemsOrdered.removeIf(m->m.getId() == id);
			System.out.println("Remove successfull");
		}
	}
	
	public boolean searchById(int id) {
		for(Media m: itemsOrdered) {
			if(m.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public float totalCost() {
		float total = 0.0f;
		for(Media media: itemsOrdered) {
			total += media.getCost();
		}
		
		return total;
	}
	
	public void addBookToOrder(Order anOrder) {
		Scanner input = new Scanner(System.in);
		System.out.printf("\tEnter id: ");
		int id = input.nextInt();
		while(searchById(id) == true) {
			System.out.println("This id is existed! Enter again!");
			id = input.nextInt();
		}
		input.nextLine();
		System.out.printf("\tEnter title: ");
        String title = input.nextLine();
        System.out.printf("\tEnter category: ");
        String category = input.nextLine();
        System.out.printf("\tEnter cost: ");
        float cost = input.nextFloat();
        Book newBook = new Book(id, title, category, cost);
        System.out.println("\tEnter numbers of author: ");
        int authorNums = input.nextInt();
        while(authorNums <= 0) {
        	System.out.println("Numbers of author must greater than 0");
        	System.out.printf("\tEnter numbers of author: ");
        	authorNums = input.nextInt();
        }
        input.nextLine();
        while(authorNums > 0) {
            System.out.printf("\tEnter author: ");
            String author = input.nextLine();
            newBook.addAuthor(author);
            authorNums--;
        }
        anOrder.addMedia(newBook);
	}
	
	public void addDvdToOrder(Order anOrder) {
		Scanner input = new Scanner(System.in);
		System.out.println("\tEnter id: ");
		int id = input.nextInt();
		while(searchById(id) == true) {
			System.out.println("This id is existed! Enter again!");
			id = input.nextInt();
		}
		input.nextLine();
		System.out.printf("\tEnter title: ");
        String title = input.nextLine();
        System.out.printf("\tEnter category: ");
        String category = input.nextLine();
        System.out.printf("\tEnter director: ");
        String director = input.nextLine();
        System.out.printf("\tEnter cost: ");
        float cost = input.nextFloat();
        System.out.printf("\tEnter length: ");
        int length = input.nextInt();
        input.nextLine();
        DigitalVideoDisc newDVD = new DigitalVideoDisc(id, title, category, director, length, cost);
        anOrder.addMedia(newDVD);
	}
	
	public void displayItemsOfOrder() {
		System.out.println("************Order List***************");
		dateOrdered.print();
		this.itemsOrdered.forEach(m -> System.out.println(m.toString()));
		System.out.println("Total cost: " + totalCost());
		System.out.println("*************************************\n");
	}
}


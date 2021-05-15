package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.exception.*;
import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.MyDate;
	

import java.util.Scanner;
import java.util.ArrayList;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;
	private MyDate dateOrdered;
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>(); 
	private int thresholdsTotal;
    private float thresholdsSale;
    
	public Order() {
		if(nbOrders >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is full, can't make any new order!");
			System.exit(0);
		} else {
			dateOrdered = new MyDate();
			nbOrders++;
			System.out.println("Creat new order successfully!");
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
	
	public int removeMedia(int id) {
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
		return check;
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
	
	public void addDvdToOrder(Order anOrder) throws PlayerException{
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
	
	public void addCdToOrder(Order anOrder) throws PlayerException {
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
        System.out.printf("\tEnter cost: ");
        float cost = input.nextFloat();
        System.out.printf("\tEnter artist: ");
        String artist = input.nextLine();
        input.nextLine();
        System.out.printf("\tEnter number of tracks: ");
        int track_num = input.nextInt();
        while(track_num <= 0) {
        	System.out.println("The number of tracks must greater than 0");
        	track_num = input.nextInt();
        }
        input.nextLine();
        CompactDisc cd = new CompactDisc(id, title, category, artist, cost);
        Track track = null;
        for(int i = 0; i < track_num; i++) {
        	System.out.println("\t\tTrack " + (i+1) + " :");
        	System.out.printf("\t\tEnter title: ");
        	String track_title = input.nextLine();
        	System.out.printf("\t\tEnter length: ");
        	int track_length = input.nextInt();
        	track = new Track(track_length, track_title);
        	cd.addTrack(track);
        	input.nextLine();
        }
        anOrder.addMedia(cd);
        String choose;
        do {
        	System.out.println("\t\tDo you want to play? \n1.Yes 2.No");
        	choose = input.nextLine();
        	choose = choose.toLowerCase();
        	if(choose.equals("yes")) {
        		cd.play();
        	} else if(choose.equals("no")) {
        		
        	} else {
        		System.out.println("Incorrect Syntax");
        	}
        } while(choose.equalsIgnoreCase("no") == false && choose.equalsIgnoreCase("yes") == false);
        
	}
	
	public Media getALuckyItem() throws LuckyItemException {
        if(itemsOrdered.size() >= nbOrders && this.totalCost() >= thresholdsTotal) {
            if(checkOrder(this) == 1) {
                int item = 0;
                do {
                    double rand = Math.random();
                    rand *= itemsOrdered.size();
                    item = (int)rand;
                } while (itemsOrdered.get(item).getCost() <= this.totalCost()*thresholdsSale);
                return itemsOrdered.get(item);
            }else {
                throw new LuckyItemException("Tất cả hàng đều lớn hơn ngưỡng quà tặng (" + totalCost()*thresholdsSale + ")");
            }
        }else {
            throw new LuckyItemException("Không đủ điều kiện nhận sản phẩm may mắn\nSố sản phẩm >= " + nbOrders + "\nTổng đơn hàng >= " + thresholdsTotal);
        }
    }

	
	public void displayItemsOfOrder() {
		System.out.println("************Order List***************");
		dateOrdered.print();
		this.itemsOrdered.forEach(m -> System.out.println(m.toString()));
		System.out.println("Total cost: " + totalCost());
		System.out.println("*************************************\n");
	}
	
	private int checkOrder(Order order) {
        for(Media media: order.itemsOrdered) {
            if(media.getCost() <= order.totalCost()*thresholdsSale)
                return 1;
        }
        return 0;
    }
	
	public void setThresholds(int thresholdsTotal, float thresholdsSale) {
        this.thresholdsTotal = thresholdsTotal;
        this.thresholdsSale = thresholdsSale;
    }
}


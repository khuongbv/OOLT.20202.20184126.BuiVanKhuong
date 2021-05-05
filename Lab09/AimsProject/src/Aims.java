import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

public class Aims {
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("**********************************");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item be id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("**********************************");
		System.out.println("Please choose a number: 0-1-2-3-4\n");
	}
	
	public static void showMenuMedia() {
        System.out.println("\tSelect Book or DVD ");
        System.out.println("\t*****************************");
        System.out.println("\t1. Book");
        System.out.println("\t2. DVD");
        System.out.println("\t3. CD");
        System.out.println("\t0. Exit");
        System.out.println("\t*****************************");
        System.out.println("\tPlease choose a number: 0-1-2-3");
    }
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Order anOrder = null;
		int checkCase = 0;
		while(1 != 0) {
			showMenu();
			String choose = input.nextLine();
			switch(choose) {
				case "1":
					anOrder = new Order();
					System.out.println("Create new order successfull");
					checkCase = 1;
					break;
				case "2":
					if(checkCase != 1) {
						System.out.println("Enter case 1");
						break;
					}
					String mediaChoose = "9";
					showMenuMedia();
					mediaChoose = input.nextLine();
					switch(mediaChoose) {
						case "1":
							anOrder.addBookToOrder(anOrder);
							break;
						case "2":
							anOrder.addDvdToOrder(anOrder);
							break;
						case "3":
							anOrder.addCdToOrder(anOrder);
							break;
						case "0":
							System.out.println("Exit submenu");
							break;
						default:
							System.out.println("Error input");
							break;
					}
					break;
				case "3":
					if(checkCase != 1) {
						System.out.println("Enter case 1");
						break;
					}
					System.out.println("Enter id: ");
					int id = input.nextInt();
					input.nextLine();
					anOrder.removeMedia(id);
					break;
				case "4":
					if(checkCase != 1) {
						System.out.println("List is Empty!");
						break;
					}
					anOrder.displayItemsOfOrder();
					break;
				case "0":
					input.close();
					System.out.println("Exit");
					System.exit(0);
					break;
				default:
					System.out.println("Error input!");
			}
		}
	}
	
	
}

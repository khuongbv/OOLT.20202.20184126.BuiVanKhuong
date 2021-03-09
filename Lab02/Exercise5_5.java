import java.util.Scanner;
public class Exercise5_5 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input a month: ");
        String month = keyboard.nextLine();
        int year;
        boolean isLeap = false;

        do {
            System.out.println("Input year: ");
            while(!keyboard.hasNextInt()) {
                System.out.println("Year must be a number!");
                keyboard.next();
            }
            year = keyboard.nextInt();
        } while(year <= 0);

        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) {
                    isLeap = true;
                } else isLeap = false;
            } else isLeap = true;
        } else isLeap = false;

        if(isLeap == true) {
            switch (month) {
                case "January": case "Jan.": case "Jan": case "1": 
                case "March": case "Mar.": case "Mar": case "3": 
                case "May": case "5":
                case "July": case "Jul": case "7":
                case "August": case "Aug.": case "Aug": case "8":
                case "October": case "Oct.": case "Oct": case "10":
                case "December": case "Dec.": case "Dec": case "12":
                    System.out.println(month + "/" + year + " have 31 days");
                    break;
                case "February": case "Feb.": case "Feb": case "2":
                    System.out.println(month + "/" + year + " have 29 days");
                    break;
                default:
                    System.out.println(month + "/" + year + " have 30 days");
            }
        } else {
            switch (month) {
                case "January": case "Jan.": case "Jan": case "1": 
                case "March": case "Mar.": case "Mar": case "3": 
                case "May": case "5":
                case "July": case "Jul": case "7":
                case "August": case "Aug.": case "Aug": case "8":
                case "October": case "Oct.": case "Oct": case "10":
                case "December": case "Dec.": case "Dec": case "12":
                    System.out.println(month + "/" + year + " have 31 days");
                    break;
                case "February": case "Feb.": case "Feb": case "2":
                    System.out.println(month + "/" + year + " have 28 days");
                    break;
                default:
                    System.out.println(month + "/" + year + " have 30 days");
            }
        }

        keyboard.close();
    }
}

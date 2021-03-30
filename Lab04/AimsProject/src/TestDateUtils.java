public class TestDateUtils {
    public static void main(String[] args){
        int test = DateUtils.compare2Dates("2000/04/02", "2000/04/01");
        if(test == 1) {
            System.out.println("Date 1 is before Date 2");
        } else if(test == -1) {
            System.out.println("Date 1 is after Date 2");
        } else if(test == 0) {
            System.out.println("Date 1 is equal Date 2");
        } else {
            System.out.println("Error!");
            System.exit(0);
        }

        String[] date_test = {"2000/04/02", "2000/04/01", "2001/02/02", "1999/01/01"};
        System.out.println("\nDate before sort: ");
        DateUtils.printList(date_test);
        DateUtils.sortDate(date_test);
        System.out.println("\nDate after sort: ");
        DateUtils.printList(date_test);
    }
}

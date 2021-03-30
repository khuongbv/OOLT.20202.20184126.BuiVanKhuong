import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class DateUtils {
    public static int compare2Dates(String date1, String date2) {
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date start = null;
        Date end = null;
        try{
            start = formatter.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try{
            end = formatter.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (start.compareTo(end) > 0) {
            return 1;
        } else if (start.compareTo(end) < 0) {
            return -1;
        } else if (start.compareTo(end) == 0) {
            return 0;
        } else {
            System.out.println("Something weird happened...");
            return 99;
        }
    }

    public static void sortDate(String[] my_date) {
        for (int i = 0; i < my_date.length - 1; i++) {
            for (int j = i + 1; j < my_date.length; j++) {
                if (compare2Dates(my_date[i], my_date[j]) == 1) {
                    String tmp = my_date[i];
                    my_date[i] = my_date[j];
                    my_date[j] = tmp;
                }
            }
        }
    }

    public static void printList(String[] my_date){
        for(String date: my_date) {
            System.out.println(date);
        }
    }
}

package hust.soict.hedspi.aims.utils;

public class DateTest {
    public static void main(String[] args){
        MyDate testDate = new MyDate("second", "September", "twenty twenty");
        testDate.print();
        testDate.printCurrentDate();
        testDate.printDateFormat();
    }
}

package aims;

public class DateTest {
	public static void main(String[] args ) {
		MyDate date1 = new MyDate();
		date1.setMonth(2);
		date1.setYear(2001);
		date1.setDay(28);
		date1.print();
		MyDate date2 = new MyDate();
		date2.print();
		MyDate date3 = new MyDate(31, 3, 2021);
		date3.print();
		MyDate date4 = new MyDate("April 2th 2000");
		date4.print();
		date1.accept();
		date1.print();
	}
}

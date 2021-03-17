package aims;

import java.time.LocalDate;
import java.util.Scanner;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day < 1 || day > getDaysOfMonth(month, year)) {
			System.out.println("Invalid Day!");
			System.exit(0);
		} else {
			this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month < 1 || month > 12) {
			System.out.println("Invalid Month!");
			System.exit(0);
		} else {
			this.month = month;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year < 0) {
			System.out.println("Invalid Year!");
			System.exit(0);
		} else {
			this.year = year;
		}
	}

	public MyDate() {
		super();
		this.day = LocalDate.now().getDayOfMonth();
		this.month = LocalDate.now().getMonthValue();
		this.year = LocalDate.now().getYear();
	}

	public MyDate(int day, int month, int year) {
		if(month < 0 || month > 12) {
			System.out.println("Invalid Month!");
			System.exit(0);
		} else {
			this.month = month;
		}
		if(year < 0) {
			System.out.println("Invalid Year!");
			System.exit(0);
		} else {
			this.year = year;
		}
		if(day < 1 || day > getDaysOfMonth(month, year)) {
			System.out.println("Invalid Day!");
			System.exit(0);
		} else {
			this.day = day;
		}
	}
	
	public MyDate(String date) {
		int Date[] = getDateFromString(date);
		this.day = Date[0];
		this.month = Date[1];
		this.year = Date[2];
	}
	
	public int isLeapYear(int year) {
		int isLeap = 0;
		if(year % 4 == 0) {
            if( year % 100 == 0) {
                if ( year % 400 == 0) {
                	isLeap = 1;
                } else {
                	isLeap = 0;
                }
            } else {
            	isLeap = 1;
            }
        } else {
            isLeap = 0;
        }
		return isLeap;
	}
	
	public int getDaysOfMonth(int month, int year) {
		int checkLeapYear = isLeapYear(year);
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				return 31;
			case 4: case 6: case 9: case 11:
				return 30;
			case 2:
				if(checkLeapYear == 1) {
					return 29;
				} else {
					return 28;
				}
			default:
				return 0;
		}
	}
	
	public int getMonthFromString(String month) {
		month = month.toLowerCase();
		switch(month) {
			case "january":
				return 1;
			case "february":
				return 2;
			case "march":
				return 3;
			case "april":
				return 4;
			case "may":
				return 5;
			case "june":
				return 6;
			case "july":
				return 7;
			case "august":
				return 8;
			case "september":
				return 9;
			case "october":
				return 10;
			case "november":
				return 11;
			case "december":
				return 12;
			default:
				return -1;
		}
	}
	
	public int getDayFromString(String day) {
		if(day.length() < 3) {
			System.out.println("Invalid Day Format!");
			System.exit(0);
		}
		int numDay;
		String day_form = day.substring(day.length() - 2).toLowerCase();
		if(day.length() > 2) {
			if(day_form.equals("st") || day_form.equals("nd") || day_form.equals("rd") || day_form.equals("th")) {
				day = day.substring(0, day.length() - 2);
			}
		} else {
			System.out.println("Invalid value");
			System.exit(0);
		}
		numDay = Integer.parseInt(day);
		return numDay;
	}
	
	public int[] getDateFromString(String date) {
		int check_space = 0;
		for(int i = 0; i < date.length(); i++) {
			if(Character.isWhitespace(date.charAt(i))) {
				check_space++;
			}
		}
		if(check_space != 2) {
			System.out.println("Invalid value");
			System.exit(0);
		} 
		String[] numDate = date.split(" ");
		boolean error = false;
		
		int d = getDayFromString(numDate[1]);
		
		int m = getMonthFromString(numDate[0]);
		if(m == -1) {
			System.out.println("Month is not correct!");
			error = true;
		}
		
		int y = Integer.parseInt(numDate[2]);
		if(y < 0) {
			System.out.println("Year is not correct!");
			error = true;
		}
		if(error == false) {
			if(d < getDaysOfMonth(m, y)) {
				int[] Date = {d, m, y};
				return Date;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public void accept() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter date: ");
		String inputDate = input.nextLine();
		int[] Date = getDateFromString(inputDate);
		if(Date != null) {
			this.month = Date[1];
			this.day = Date[0];
			this.year = Date[2];
		}
		input.close();
	}
	
	public void print() {
		System.out.println(this.day + "/" + this.month + "/" + this.year);
	}
}

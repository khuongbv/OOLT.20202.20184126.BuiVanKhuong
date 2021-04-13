package hust.soict.hedspi.aims.utils;

import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
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
	
	public MyDate(String date, String month, String year) {
		String[][] date_string_name = {
									{"first", "1"},{"second", "2"},{"third", "3"}, {"fourth", "4"}, {"fifth", "5"}, {"sixth", "6"},
									{"seventh", "7"}, {"eighth", "8"}, {"ninth", "9"}, {"tenth", "10"}, {"eleventh", "11"}, {"twelfth", "12"},
									{"thirteenth", "13"}, {"fourteenth", "14"}, {"fifteenth", "15"}, {"sixteenth", "16"}, {"seventeenth", "17"}, {"eighteenth", "18"}, {"nineteenth", "19"},
									{"twentieth", "20"}, {"twenty-first", "21"}, {"twenty-second", "22"}, {"twenty-third", "23"},
									{"twenty-fourth", "24"}, {"twenty-fifth", "25"}, {"twenty-sixth", "26"}, {"twenty-seventh", "27"},
									{"twenty-eighth", "28"}, {"twenty-ninth", "29"}, {"thirtieth", "30"}, {"thirty-first", "31"}};
		String[] year_string_name = {
								"nineteen ninety one", "nineteen ninety two", "nineteen ninety three", "nineteen ninety four", 
								"nineteen ninety five", "nineteen ninety six", "nineteen ninety seven", "nineteen ninety eight", "nineteen ninety nine",
								"two thousand", "two thousand and one", "two thousand and two", "two thousand and three", "two thousand and four",
								"two thousand and five", "two thousand and six", "two thousand and seven", "two thousand and eight", "two thousand and nine",
								"two thousand and ten", "twenty eleven", "twenty twelse", "twenty thirteen", "twenty fourteen", "twenty fifteen",
								"twenty sixteen", "twenty seventeen", "twenty eighteen", "twenty nineteen", "twenty twenty", "twenty twenty one"
		};

		for(int i = 0; i < 31; i++) {
            if(date.equalsIgnoreCase(date_string_name[i][0])) {
                this.day = Integer.parseInt(date_string_name[i][1]);
            }
        }

		this.month = getMonthFromString(month);
		for(int i = 0; i < 31; i++) {
			if(year.equalsIgnoreCase(year_string_name[i])) {
				this.year = i + 1991;
			}
		}
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
	
	public void printCurrentDate() {
		MyDate currentDate = new MyDate();
		String currentMonth = "";
		switch(currentDate.getMonth()) {
			case 1: 
				currentMonth = "January";
				break;
			case 2:  
				currentMonth = "February";
				break;
			case 3:  
				currentMonth = "March";
				break;
			case 4:  
				currentMonth = "April";
				break;
			case 5:  
				currentMonth = "May";
				break;
			case 6:  
				currentMonth = "June";
				break;
			case 7:  
				currentMonth = "July";
				break;
			case 8:  
				currentMonth = "August";
				break;
			case 9:  
				currentMonth = "September";
				break;
			case 10: 
				currentMonth = "October";
				break;
			case 11: 
				currentMonth = "November";
				break;
			case 12: 
				currentMonth = "December";
				break;
			default:
				currentMonth =  "";
				break;
		}
		if(currentDate.getDay() == 1 || currentDate.getDay() == 11 || currentDate.getDay() == 21) {
			System.out.println("Today is: " + currentMonth + " " + currentDate.getDay() + "st " + currentDate.getYear());
		} else if(currentDate.getDay() == 2 || currentDate.getDay() == 12 || currentDate.getDay() == 22){
			System.out.println("Today is: " + currentMonth + " " + currentDate.getDay() + "nd " + currentDate.getYear());
		} else if(currentDate.getDay() == 3 || currentDate.getDay() == 13 || currentDate.getDay() == 23){
			System.out.println("Today is: " + currentMonth + " " + currentDate.getDay() + "rd " + currentDate.getYear());
		} else {
			System.out.println("Today is: " + currentMonth + " " + currentDate.getDay() + "th " + currentDate.getYear());
		}
	}

	public void printDateFormat() {
		Date today = new Date();
		String date_format = "";
		int choose;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select format: \n 1. yyyy-MM-dd \n 2. d/M/yyyy \n 3. dd-MMM-yyyy \n 4. MMM d yyyy\n 5. mm-dd-yyyy");
		choose = keyboard.nextInt();
		switch(choose) {
			case 1:
				date_format = "yyyy-MM-dd";
				break;
			case 2:
				date_format = "d/M/yyyy";
				break;
			case 3:
				date_format = "dd-MMM-yyyy";
				break;
			case 4:
				date_format = "MMM d yyyy";
				break;
			case 5:
				date_format = "MM-dd-yyyy";
				break;
			default:
				date_format = "MMMM dd yyyy";
				break;
		}
		keyboard.close();
		SimpleDateFormat printDateForm = new SimpleDateFormat(date_format);
		System.out.println(printDateForm.format(today));
	}

	public void print() {
		if(month < 0 || month > 12) {
			System.out.println("Invalid Month!");
			System.exit(0);
		} else if(year < 0) {
			System.out.println("Invalid Year!");
			System.exit(0);
		} else if(day < 1 || day > getDaysOfMonth(month, year)) {
			System.out.println("Invalid Day!");
			System.exit(0);
		}
		System.out.println(this.day + "/" + this.month + "/" + this.year);
	}
}

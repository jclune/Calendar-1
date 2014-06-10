//code by Justin Clune
import java.util.*;
import java.text.*;

public class Calendar_v1{
	public static void main(String[] args){
		Calendar cal = Calendar.getInstance();

		//today
		cal.add(Calendar.DATE, 1);
		Date today = cal.getTime();

		//first day of the month
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfMonth = cal.getTime();

		//first  day of week (1 = Sun, 2 = Mon, 3 = Tues...7) and number of days in month
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int numberDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		SimpleDateFormat month = new SimpleDateFormat("MM");

		//today and weekday labels
		System.out.println(year.format(today) + "年" + month.format(today) + "月" + "のカレンダーを出力します");
		System.out.println(year.format(today) + "年" + month.format(today) + " 月");
		System.out.println("日 月 火 水 木 金 土");
		
		//3 characters per day and 7 days, so  each row is 21 characters long
		String spaces = "                     ";

		//make one string for all days with correct spacing for single digits
		String allDays = "";
		for (int i = 1; i <= numberDays; i++){
			if (i < 10){
				allDays = allDays + " " + i + " ";
			} else{
				allDays = allDays + i + " ";
			}
		}

		//output rows of days by taking substrings. indexes use the first day of the week
		int start = 3*(dayOfWeek-1);
		System.out.println(spaces.substring(0,start)+allDays.substring(0,21-start));		
		System.out.println(allDays.substring(21-start,42-start));
                System.out.println(allDays.substring(42-start,63-start));
                System.out.println(allDays.substring(63-start,84-start));

		//if the month has 6 rows, then print the last 2 rows. else print 1.
		if ((numberDays == 30 && dayOfWeek == 7) || (numberDays == 31 && dayOfWeek >= 6)){
	                System.out.println(allDays.substring(84-start,105-start));
	                System.out.println(allDays.substring(105-start,allDays.length()));
		}else{
                	System.out.println(allDays.substring(84-start,allDays.length()));
		}	
	}
}

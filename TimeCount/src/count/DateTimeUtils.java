package count;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

	public static void main(String[] args) {
		
		  SimpleDateFormat simpleDateFormat = 
	                new SimpleDateFormat("dd/M/yyyy hh:mm:ss");

		  try {
				
			Date date1 = simpleDateFormat.parse("03/04/2020 11:30:55");
			Date date2 = simpleDateFormat.parse("03/04/2020 20:35:55");
				
			printDifference(date1, date2);
				
		  } catch (ParseException e) {
			e.printStackTrace();
		  }
			
		}
		
		//1 minute = 60 seconds
		//1 hour = 60 x 60 = 3600
		//1 day = 3600 x 24 = 86400
		public static void printDifference(Date startDate, Date endDate){
		
			//milliseconds
			long different = endDate.getTime() - startDate.getTime();
			
			System.out.println("startDate : " + startDate);
			System.out.println("endDate : "+ endDate);
			System.out.println("different : " + different);
			System.out.println("----------------------");
			
			long secondsInMilli = 1000;
			long minutesInMilli = secondsInMilli * 60;
			long hoursInMilli = minutesInMilli * 60;
			long daysInMilli = hoursInMilli * 24;
			
			System.out.println("secondsInMilli "+secondsInMilli);
			System.out.println("minutesInMilli "+minutesInMilli);
			System.out.println("hoursInMilli "+hoursInMilli);
			
			long elapsedDays = different / daysInMilli;
			different = different % daysInMilli;
			System.out.println("elapsedDays "+elapsedDays);
			//System.out.println("different "+different);
			
			long elapsedHours = different / hoursInMilli;
			System.out.println("elapsedHours "+elapsedHours);
			different = different % hoursInMilli;
			
			long elapsedMinutes = different / minutesInMilli;
			different = different % minutesInMilli;
			
			long elapsedSeconds = different / secondsInMilli;
			
			System.out.printf(
			    "%d days, %d hours, %d minutes, %d seconds%n", 
			    elapsedDays,
			    elapsedHours, elapsedMinutes, elapsedSeconds);
		
	}

}

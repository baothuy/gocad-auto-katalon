package katalon.utility

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.LocalDate

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter


public class DateTimeUtility {

	public String getCurrentDateTime(String format = "MM/dd/YYYY") {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static String getDateTimeFromCurrent(int days = 0) {
		def currentDateTime = LocalDateTime.now()
		def dateFromCurrent = currentDateTime.plusDays(days)
		return dateFromCurrent
	}

	public static Number changeFormatDateToMilliseconds(String format = "yyyy-MM-dd'T'HH:mm:ss.SSS",String dateTimeString) {
		def dateFormat = new SimpleDateFormat(format)
		def dateTime = dateFormat.parse(dateTimeString)
		def timestamp = dateTime.time
		return timestamp
	}

	public static DateTime changeFormatToDateTime(String format = "yyyy-MM-dd'T'HH:mm:ss.SSS",String dateString) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format)
		def dateTime = dateTimeFormatter.parseDateTime(dateString)
		return dateTime
	}

	public static String changeDateFormat(String dateString, String oldFormat = "MMMM d, yyyy", String newFormat = "MM/dd/yyyy") {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(oldFormat)
		DateTime dateTime = dateTimeFormatter.parseDateTime(dateString)
		// Define the desired output format for DateTime
		DateTimeFormatter outputFormatter = DateTimeFormat.forPattern(newFormat)
		// Format the DateTime into the desired output format
		String formattedDate = outputFormatter.print(dateTime)
		return formattedDate
	}

	public static String plusMinutes(int numberOfMinutes, String format = "MM/dd/yyyy HH:mm") {
		Calendar date = Calendar.getInstance()
		long timeInSecs = date.getTimeInMillis()
		Date afterAddingMins = new Date(timeInSecs + (numberOfMinutes * 60 * 1000))
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(afterAddingMins);
	}

	public static String plusDays(int numberOfDays, String format = "ddMMyyHHmmss") {
		Date date = new Date().plus(numberOfDays);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static String currentDay(String format = "MMMMM d, YYYY") {
		plusDays(0, format);
	}

	public static String next30Days(String format = "MMMM d, YYYY") {
		plusDays(30, format);
	}

	public static String nextYear(String format = "MMMM d, YYYY") {
		def CurrentYear = Calendar.getInstance().get(Calendar.YEAR)
		if (CurrentYear % 4 == 0 && CurrentYear % 100 != 0 || CurrentYear % 400 == 0) {
			// Leap year: 366 days
			def days = 366 + 1
			plusDays(days, format);
		} else {
			// Non-leap year: 365 days
			def days = 365 + 1
			plusDays(days, format);
		}
	}
}

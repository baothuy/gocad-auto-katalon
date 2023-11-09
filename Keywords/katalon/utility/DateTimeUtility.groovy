package katalon.utility

import java.text.SimpleDateFormat
import java.time.LocalDateTime

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter


public class DateTimeUtility {

	// Define your list of holiday dates in the format "MM/dd/yyyy"

	def static isHoliday(date) {
		def holidays = [
			"12/25/2023",
			"12/26/2023",
			"01/01/2024",
			"01/06/2024",
			"03/29/2024",
			"04/01/2024",
			"05/01/2024",
			"05/09/2024",
			"05/20/2024",
			"05/30/2024",
			"10/03/2024",
			"11/01/2024",
			"12/25/2024",
			"12/26/2024"]
		def dateFormat = new SimpleDateFormat("MM/dd/yyyy")
		def formattedDate = dateFormat.format(date)

		// Check if the formatted date is in the list of holidays
		return formattedDate in holidays
	}

	public static String getDeliveryWorkingDate(int workingDaysToAdd) {
		def currentDate = new Date()
		// Create a Calendar instance and set it to the current date
		def calendar = Calendar.getInstance()
		calendar.time = currentDate

		// Loop to add working days
		while (workingDaysToAdd > 0) {
			// Add one day to the current date
			calendar.add(Calendar.DAY_OF_MONTH, 1)
			def nextDate = calendar.time
			println "nextDate: $nextDate"
			// Check if the next date is a weekend (Saturday or Sunday) or a holiday
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
			calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
			isHoliday(nextDate)) {
				continue  // Skip weekends and holidays
			}
			workingDaysToAdd--
		}
		// Get the calculated delivery date
		def deliveryDate = calendar.time

		// Format the delivery date in your desired format
		def dateFormat = new SimpleDateFormat("MM/dd/yyyy")
		def formattedDeliveryDate = dateFormat.format(deliveryDate)

		println("Delivery Date: $formattedDeliveryDate")
		return formattedDeliveryDate
	}

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

	public static String nextWeek(String format = "MMMM d, YYYY") {
		plusDays(7, format);
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

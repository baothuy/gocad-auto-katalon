package katalon.utility

import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter

public class DateTimeUtility {

	public String getCurrentDateTime(String format = "MM/dd/YYYY") {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
}

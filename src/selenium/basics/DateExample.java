package selenium.basics;

import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString());
		String dateTime = d.toString();
		String dateTimeText = dateTime.replace(" ", "_").replace(":", "_");
		System.out.println(dateTimeText);

	}
}

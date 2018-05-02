package homeWork_II;
import java.text.DateFormat; 
import java.util.Calendar;
import java.util.Date; 
public class MyCalendar {

	public String getTime(int daysAfter) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DATE, daysAfter);
		Date date = calendar.getTime();
		DateFormat format = DateFormat.getDateInstance(DateFormat.FULL); 
		String string = format.format(date); 
		return string;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MyCalendar myCalendar=new MyCalendar();
		System.out.println(myCalendar.getTime(150));

	}

}

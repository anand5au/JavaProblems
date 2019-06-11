package problems;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MagicTime
{
	public static boolean IsMagicNumber(long num)
	{
		boolean[] isPresent = new boolean[10];
		int count = 0;
		while (num > 0)
		{
			int digit = (int) (num % 10);
			if (!isPresent[digit])
			{
				isPresent[digit] = true;
				count++;
			}
			num /= 10;
		}
		return count == 2 ? true : false;
	}

	public static void printMagicTime(String a, String b) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = df.parse(a);
		Date d2 = df.parse(b);
		df = new SimpleDateFormat("yyyyMMddHHmm");
		Calendar cal = new GregorianCalendar();
		cal.setTime(d1);
		while (cal.getTime().before(d2))
		{
			long tempDate = Long.parseLong(df.format(cal.getTime()));
			if (IsMagicNumber(tempDate))
				System.out.println(cal.getTime());
			cal.add(Calendar.MINUTE, 1);
		}
	}

	public static void main(String[] args)
	{
		try
		{
			printMagicTime("1100/10/05 12:07", "1110/01/20 12:09");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}

}

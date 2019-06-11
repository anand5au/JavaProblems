package problems;

public class RLE
{
	public static String compressBad(String str)
	{
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++)
		{
			if (str.charAt(i) == last)
			{
				count++;
			}
			else
			{
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}

	public static void main(String[] args)
	{
		String str = "abcd";
		String str2 = compressBad(str);
		System.out.println("New String (len = " + str2.length() + "): " + str2);
	}

}

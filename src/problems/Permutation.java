package problems;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Permutation
{
	public static List<String> perm(String s)
	{
		if (s == null)
			return null;
		List<String> permList = new ArrayList<String>();
		if (s.isEmpty())
		{
			permList.add("");
			return permList;
		}

		char first = s.charAt(0);
		String remaining = s.substring(1);
		List<String> inter = perm(remaining);

		for (String str : inter)
		{
			for (int i = 0; i <= str.length(); i++)
				permList.add(insertAt(str, first, i));
		}
		return permList;
	}

	public static String insertAt(String s, char c, int i)
	{
		return (s.substring(0, i) + c + s.substring(i));
	}

	// alternative approach
	static ArrayList<String> getPerms(String s)
	{
		ArrayList<String> result = new ArrayList<>();
		getPerms("", s, result);
		return result;
	}

	static void getPerms(String prefix, String rem, ArrayList<String> result)
	{
		if (rem.length() == 0)
			result.add(prefix);

		int len = rem.length();
		for (int i = 0; i < len; i++)
		{
			String before = rem.substring(0, i);
			String after = rem.substring(i + 1);
			char c = rem.charAt(i);
			getPerms(prefix + c, before + after, result);
		}
	}

	public static void main(String[] args)
	{
		String a = "aaaaaa";
		System.out.println(new Date());
		System.out.println(perm(a).size());
		System.out.println(new Date());
		System.out.println(getPerms(a).size());
		System.out.println(new Date());
	}

}

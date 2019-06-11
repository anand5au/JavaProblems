package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMutation
{
	public static void main(String args[])
	{
		String bank[] = { "AAAAAAAA", "AAAAAAAT", "AAAAAATT", "AAAAATTT" };
		String start = "AAAAAAAA";
		String end = "AAAAATTT";
		int dist = minMutation(start, end, bank);
		System.out.println(dist);
	}

	public static int minMutation(String start, String end, String[] bank)
	{
		if (bank == null || start == null || start.length() == 0 || end == null || end.length() == 0)
			return 0;

		Set<String> bankStrings = new HashSet<String>();
		for (String s : bank)
			bankStrings.add(s);

		if (!bankStrings.contains(end))
			return -1;

		int count = minMutation(start, end, bankStrings);
		return count == 0 ? -1 : count;
	}

	public static int minMutation(String start, String end, Set<String> bankStrings)
	{
		List<Integer> indices = new ArrayList<>();
		int length = start.length();
		for (int i = 0; i < length; ++i)
		{
			if (start.charAt(i) != end.charAt(i))
				indices.add(i);
		}
		int curCount = 0;
		String temp = "";
		for (int i : indices)
		{
			temp = start.substring(0, i) + "" + end.charAt(i) + "" + start.substring(i + 1, length);
			if (bankStrings.contains(temp))
				curCount = 1 + minMutation(temp, end, bankStrings);
		}
		return curCount;
	}
}

package problems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
	public static void printAllSets(char[] c)
	{
		List<String> list = new ArrayList<String>();
		printSets(c, 0, list);
		System.out.println(list);
		System.out.println(list.size());
	}

	private static void printSets(char[] c, int index, List<String> list)
	{
		if (index == c.length)
			return;
		int len = list.size();

		for (int i = 0; i < len; i++)
			list.add(list.get(i) + c[index]);

		list.add(c[index] + "");
		index++;
		printSets(c, index, list);
	}

	public static void main(String args[])
	{
		char[] c = { 'a', 'b', 'c', 'd', 'e' };
		printAllSets(c);
	}
}

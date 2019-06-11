package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfusingFibbonaci
{
	public static void main(String[] args)
	{
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(1);
		int n = l.size();

		while (n < 8)
		{
			n = l.size();
			l.add(l.get(n - 1) + l.get(n - 2));
			n++;
		}
		System.out.println(Arrays.toString(l.toArray()));
		System.out.println(l.get(l.size() - 1));
	}
}

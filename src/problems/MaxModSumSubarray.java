package problems;

import java.util.TreeSet;

public class MaxModSumSubarray
{
	static void maxModSumSubarray(long[] a, int m)
	{
		TreeSet<Long> s = new TreeSet<Long>();
		long sum = 0, ans = -1, n = a.length;
		for (int i = 0; i < n; i++)
		{
			if (i == 0)
			{
				sum = a[i] % m;
				ans = Math.max(ans, sum);
				s.add(sum);
			}
			else
			{
				sum = (sum + (a[i] % m)) % m;
				Long temp = s.higher(sum);
				ans = Math.max(ans, (sum - ((temp == null) ? 0 : temp) + m) % m);
				s.add(sum);
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args)
	{
		long a[] = { 3, 3, 9, 9, 5 };
		maxModSumSubarray(a, 7);
	}
}

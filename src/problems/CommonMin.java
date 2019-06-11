package problems;

import java.util.*;

public class CommonMin
{

	public static int solution(int[] A, int[] B)
	{
		int result = Integer.MAX_VALUE;
		Set<Integer> hashSet = new HashSet<Integer>();
		for (int num : A)
			hashSet.add(num);

		for (int num : B)
		{
			if (!hashSet.contains(num))
				continue;
			if (num < result)
				result = num;
		}

		return (result == Integer.MAX_VALUE) ? -1 : result;
	}

	public static void main(String[] args)
	{
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
		int c = Math.addExact(a, b);
		System.out.println(c);
	}

}

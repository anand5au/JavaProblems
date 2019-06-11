package problems;

import java.util.Scanner;

public class HomeValue
{
	/*
	 * diff denotes # of increasing subranges - # of decreasing subranges in a
	 * window of given size
	 */
	static long diff = 0;

	/*
	 * enum Direction is to denote if the subrange is increasing or decreasing
	 * or none (i.e. when all elements of subarray are equal)
	 */
	enum Direction
	{
		NONE, DECR, INCR;
	}

	static int updateDiff(int start, int end, Direction dir)
	{
		/*
		 * Variable subArrays will hold # of inc/dec subranges between start and
		 * end index. It's calculated based on the formula that a set of size N
		 * has N(N+1)/2 subarrays. But here we don't need subsets of size 1.
		 * Thus N(N-1)/2 subsets.
		 */
		long size = end - start + 1;
		long subArrays = (size * (size - 1)) / 2;

		/* if the prev subrange is positive then add subArrays to diff */
		if (dir == Direction.INCR)
			diff += subArrays;
		/* if the prev subrange is negative then subtract subArrays from diff */
		else if (dir == Direction.DECR)
			diff -= subArrays;

		/* return the next start position */
		return end;
	}

	public static void calcWindowDiff(int[] a, int k)
	{
		if (a == null || a.length == 0 || k <= 0 || k > a.length)
		{
			System.out.println("Invalid Input!");
			return;
		}

		int left = 0, right = k - 1, n = a.length;

		/* start denotes start of an inc/dec subrange */
		int start = 0;

		Direction dir = Direction.NONE;

		for (; right < n; right++, left++)
		{
			start = left;
			diff = 0;
			for (int i = left; i < right; i++)
			{
				if (a[i] < a[i + 1])
				{
					/*
					 * if subrange starts increasing then update diff with # of
					 * decreasing subranges seen so far
					 */
					if (dir == Direction.DECR)
						start = updateDiff(start, i, dir);
					dir = Direction.INCR;
				}
				else if (a[i] > a[i + 1])
				{
					/*
					 * if subrange starts decreasing then update diff with # of
					 * increasing subranges seen so far
					 */
					if (dir == Direction.INCR)
						start = updateDiff(start, i, dir);
					dir = Direction.DECR;
				}
				else
				{
					/*
					 * if numbers in subrange are equal then update diff with #
					 * of decreasing/increasing subranges seen so far
					 */
					start = updateDiff(start, i, dir) + 1;
					dir = Direction.NONE;
				}

				/*
				 * if we reach the end of a window then update diff with # of
				 * decreasing/increasing subranges seen so far
				 */
				if (i == right - 1)
				{
					updateDiff(start, right, dir);
					dir = Direction.NONE;
				}
			}
			System.out.println(diff);
		}
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = input.nextInt();
		calcWindowDiff(a, k);
		input.close();
	}

}

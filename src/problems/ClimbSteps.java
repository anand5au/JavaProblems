package problems;

import java.util.Arrays;

public class ClimbSteps
{
	public static long countWays(int s, long arr[])
	{
		if (s < 0)
			return 0;
		if (s == 0)
			return 1;
		if (arr[s] >= 0)
			return arr[s];
		// since we count no of ways there is no "1 + prev value" logic.
		// it is only for finding min no: of steps
		arr[s] = countWays(s - 1, arr) + countWays(s - 2, arr) + countWays(s - 3, arr);
		return arr[s];
	}

	public static int countWaysSlow(int s)
	{
		if (s < 0)
			return 0;
		if (s == 0)
			return 1;
		return countWaysSlow(s - 1) + countWaysSlow(s - 2) + countWaysSlow(s - 3);
	}

	public static void main(String[] args)
	{
		long[] arr = new long[37];
		Arrays.fill(arr, -1);
		System.out.println(countWays(4, arr));
		// System.out.println(countWaysSlow(36));
	}
}

package problems;

import java.util.Arrays;

public class RodCutting
{
	static int cutRod(int price[], int n)
	{
		int max[] = new int[n + 1];
		max[1] = price[0];
		for (int i = 2; i <= n; i++)
		{
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
				max_val = Math.max(max_val, price[j] + max[i - j - 1]);
			max[i] = max_val;
		}
		System.out.println(Arrays.toString(max));
		return max[n];
	}

	public static void main(String args[])
	{
		int arr[] = new int[] { 3, 7, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));

	}
}

package problems;

import java.util.Arrays;

public class CoinChange
{
	static int countWays(int[] coins, int n)
	{
		int[] ways = new int[n + 1];
		ways[0] = 1;

		for (int i = 0; i < coins.length; i++)
		{
			// for every new coin that you see update the array with new ways
			// only starting from that new coin since lesser denoms can't be
			// obtained.
			for (int j = coins[i]; j <= n; j++)
			{
				ways[j] += ways[j - coins[i]];
				System.out.println(Arrays.toString(ways));
			}
		}

		System.out.println(Arrays.toString(ways));
		return ways[n];
	}

	public static void main(String[] args)
	{
		int[] coins = { 4, 2, 3 };
		System.out.println("No: of ways: " + countWays(coins, 7));
	}
}

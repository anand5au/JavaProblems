package problems;

import java.util.Date;

/*
   If V == 0, then 0 coins required.
   If V > 0
   minCoin(coins[0..m-1], V) = min {1 + minCoins(V-coin[i])} 
                               where i varies from 0 to m-1 
                               and coin[i] < V
 */

public class MinCoins
{
	public static int minCoinsFast(int coins[], int m, int v)
	{
		// table[i] will be storing the minimum number of coins
		// required for i value. So table[v] will have result
		int[] table = new int[v + 1];

		// Base case (If given value v is 0)
		table[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= v; i++)
			table[i] = Integer.MAX_VALUE;

		// Compute minimum coins required for all
		// values from 1 to v
		for (int i = 1; i <= v; i++)
		{
			// Go through all coins smaller than i
			for (int j = 0; j < m; j++)
			{
				if (coins[j] < i)
				{
					int sub_res = table[i - coins[j]];
					table[i] = Math.min(sub_res + 1, table[i]);
				}
				// comment this else only if exact amount is required
				// and add check for Integer.MAX_VALUE above before finding min
				else
				{
					table[i] = 1;
				}
				// System.out.println(Arrays.toString(table));
			}
		}

		return table[v];
	}

	public static int minCoinsSlow(int coins[], int m, int v)
	{
		if (v <= 0)
			return 0;

		int res = Integer.MAX_VALUE;

		for (int j = 0; j < m; j++)
		{
			if (coins[j] <= v)
			{
				int sub_res = minCoinsSlow(coins, m, v - coins[j]);
				if (sub_res + 1 < res)
					res = sub_res + 1;
			}
			else
			{
				return 1;
			}
		}

		return res;
	}

	public static void main(String[] args)
	{
		int coins[] = { 3, 5, 7 };
		System.out.println(new Date());
		System.out.println("Minimum coins required is " + minCoinsFast(coins, coins.length, 100));
		System.out.println(new Date());
		System.out.println("Minimum coins required is " + minCoinsSlow(coins, coins.length, 100));
		System.out.println(new Date());
	}
}

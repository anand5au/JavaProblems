package problems;

import java.util.Scanner;

public class BitFlip
{
	static int findWindow(int[] bin)
	{
		int start = 0, end = 0;
		int len = bin.length, max = 0, numZeros = 0;
		int globalstart = 0;
		for (int i = 0; i < len; i++)
		{
			if (numZeros == 0 && bin[i] == 1)
			{
				start = i + 1;
				continue;
			}
			numZeros = bin[i] == 0 ? numZeros + 1 : numZeros - 1;
			if (max < numZeros)
			{
				max = numZeros;
				end = i;
				globalstart = start;
			}
		}
		if (globalstart == len)
			return len;

		int i = 0, res = 0;
		while (i < globalstart)
		{
			if (bin[i++] == 1)
				res++;
		}

		while (i <= end)
		{
			if (bin[i++] == 0)
				res++;
		}

		while (i < len)
		{
			if (bin[i++] == 1)
				res++;
		}

		return res;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int bin[] = new int[n];
		for (int i = 0; i < n; i++)
			bin[i] = sc.nextInt();
		System.out.println(findWindow(bin));
		sc.close();
	}

}

package problems;

import java.util.Arrays;

public class MinGates
{
	static int findMinGates(int[] arrivals, int[] departures, int flights)
	{
		if (flights < 1)
			return 0;
		Arrays.sort(arrivals);
		Arrays.sort(departures);

		int gates = 1, minGates = 1, i = 1, j = 0;
		while (i < flights && j < flights)
		{
			if (arrivals[i] <= departures[j])
			{
				gates++;
				i++;
				if (gates > minGates)
					minGates = gates;
			}
			else
			{
				gates--;
				j++;
			}
		}
		return minGates;
	}

	public static void main(String[] args)
	{

	}

}

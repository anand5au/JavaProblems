package problems;

import java.util.LinkedList;

public class ArrayHopper
{
	// prints the path from first touch down till end of the canyon
	static void printPath(int[] path, int idx)
	{
		if (idx == 0)
			return;
		printPath(path, path[idx]);
		System.out.print(path[idx] + ", ");
	}

	// finds the last touch down which can lead out of the canyon
	static int findLastIndex(int[] canyons)
	{
		int lastIndex = -1;
		for (int i = canyons.length - 1; i >= 0; i--)
		{
			if ((canyons[i] + i) >= canyons.length)
				lastIndex = i;
		}
		return lastIndex;
	}

	static void findPath(int[] canyons)
	{
		int size = canyons.length;
		if (size == 0 || canyons[0] == 0)
		{
			System.out.println("failure");
			return;
		}
		int hops[] = new int[size]; // stores the min touch downs from to reach
									// all points in the array.
		int path[] = new int[size]; // stores the previous touch down for all
									// points in the array.
		hops[0] = 0;

		for (int i = 1; i < size; i++)
		{
			hops[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++)
			{
				if (i <= j + canyons[j] && hops[j] != Integer.MAX_VALUE)
				{
					if (hops[i] > hops[j] + 1)
					{
						path[i] = j;
						hops[i] = hops[j] + 1;
					}
					break;
				}
			}
		}
		int lastIndex = findLastIndex(canyons);
		if (hops[size - 1] == Integer.MAX_VALUE || lastIndex == -1)
		{
			System.out.println("failure");
			return;
		}

		printPath(path, lastIndex);
		System.out.println(lastIndex + ", out");
	}

	private static void findSequence(int[] canyons)
	{
		// handle array empty or 0 at first index
		LinkedList<Integer> touchDowns = new LinkedList<Integer>();
		int max = 0, curPos = 0, hop = 0, i = 0;
		for (; i < canyons.length; i++)
		{
			if (i > curPos)
				break;
			if (i > max)
			{
				max = curPos;
				touchDowns.add(hop);
			}
			int sum = i + canyons[i];
			if (sum > curPos)
				hop = i;
			curPos = Math.max(curPos, sum);
		}

		if ((i > max) && (touchDowns.isEmpty() || touchDowns.peekLast() != hop))
			touchDowns.add(hop);

		System.out.println(max);
		if (max >= canyons.length - 1)
			System.out.println(touchDowns);
		else
			System.out.println("failure");
	}

	public static void main(String args[]) throws Exception
	{
		int[] canyons = { 2, 3 };
		findPath(canyons);
		findSequence(canyons);
	}
}

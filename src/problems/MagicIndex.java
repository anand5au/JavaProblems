package problems;

import java.util.Arrays;

public class MagicIndex
{
	/*
	 * provide different solution for Dup and NoDup variations. NoDup solution
	 * is very fast O(logn). Dup solution will work fast only for arrays with
	 * duplicates. For non-dup arrays, it is equivalent to linear search.
	 */
	// static int i = 1;

	static int magicIndex(int[] a, int low, int high)
	{
		if (low > high)
			return -1;

		// System.out.println(i++ + ": " + low + " " + high);

		int mid = low + (high - low) / 2;
		if (a[mid] == mid)
			return mid;

		int lIndex = magicIndex(a, low, Math.min(a[mid], mid - 1));
		if (lIndex >= 0)
			return lIndex;

		int rIndex = magicIndex(a, Math.max(a[mid], mid + 1), high);
		return rIndex;
	}

	static int magicIndexNoDup(int[] a, int low, int high)
	{
		while (low <= high)
		{
			// System.out.println(i++ + ": " + low + " " + high);

			int mid = low + (high - low) / 2;
			if (a[mid] == mid)
				return mid;
			else if (a[mid] < mid)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int a[] = { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13 };
		System.out.println(Arrays.toString(a));
		System.out.println(magicIndex(a, 0, a.length - 1));
		// i = 0;
		System.out.println(magicIndexNoDup(a, 0, a.length - 1));
	}
}

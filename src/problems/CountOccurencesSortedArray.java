package problems;

public class CountOccurencesSortedArray
{
	public static int countOccurences(int[] a, int x)
	{
		int i = firstOccurence(a, x);
		System.out.println("first: " + i);
		if (i == -1)
			return 0;
		int j = lastOccurence(a, i, x);
		System.out.println("last: " + j);
		return j - i + 1;
	}

	// go left if a[mid] is equal to search element
	private static int firstOccurence(int a[], int x)
	{
		int start = 0, end = a.length - 1;
		while (start <= end)
		{
			int mid = (start + end) / 2;
			if ((mid == 0 || a[mid - 1] < x) && a[mid] == x)
				return mid;
			else if (a[mid] >= x)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	// go right if a[mid] is equal to search element
	private static int lastOccurence(int a[], int i, int x)
	{
		int start = i, end = a.length - 1;
		while (start <= end)
		{
			int mid = (start + end) / 2;
			if ((mid == a.length - 1 || a[mid + 1] > x) && a[mid] == x)
				return mid;
			else if (a[mid] > x)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] a = { 2, 2, 2, 2, 2, 7, 8, 9 };
		System.out.println(countOccurences(a, 2));
	}
}

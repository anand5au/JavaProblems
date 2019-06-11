package problems;

import java.util.Arrays;
import java.util.Random;

public class QuickSort
{
	private static int partition(int[] a, int l, int r)
	{
		int i = l - 1, j = r, temp = 0;
		while (true)
		{
			while (a[++i] < a[r]);

			while (a[--j] > a[r])
				if (j == i)
					break;

			if (i >= j)
				break;

			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		if (i != r)
		{
			temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		return i;
	}

	public static void sort(int[] a, int low, int high)
	{
		if (low >= high)
			return;
		int p = partition(a, low, high);
		sort(a, low, p - 1);
		sort(a, p + 1, high);
	}

	public static void main(String[] args)
	{
		int a[] = new int[1000];
		Random r = new Random();
		for (int i = 0; i < 1000; i++)
			a[i] = r.nextInt(1000);
		System.out.println(Arrays.toString(a));
		sort(a, 0, 999);
		System.out.println(Arrays.toString(a));
	}

}

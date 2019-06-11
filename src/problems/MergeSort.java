package problems;

import java.util.Arrays;

public class MergeSort
{
	static void mergeSort(int[] a)
	{
		mergeSort(a, 0, a.length - 1);
	}

	static void mergeSort(int[] a, int start, int end)
	{
		if (start < end)
		{
			int mid = start + (end - start) / 2;
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);

			merge(a, start, mid, end);
		}
	}

	static void merge(int[] a, int start, int mid, int end)
	{
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int left[] = new int[n1];
		int right[] = new int[n2];
		for (int i = 0; i < n1; i++)
			left[i] = a[start + i];
		for (int i = 0; i < n2; i++)
			right[i] = a[mid + i + 1];

		int i = 0, j = 0, k = start;
		while (i < left.length && j < right.length)
		{
			if (left[i] <= right[j])
				a[k++] = left[i++];
			else
				a[k++] = right[j++];
		}

		while (i < left.length)
			a[k++] = left[i++];

		while (j < right.length)
			a[k++] = right[j++];
	}

	public static void main(String[] args)
	{
		int[] a = { 32, 4, 15, 66, 7, 2, 88, 45, 3, 9, 4, 23 };
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}
}

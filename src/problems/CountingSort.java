package problems;

import java.util.Arrays;

public class CountingSort
{
	static void sort(char[] a)
	{
		int n = a.length;
		char output[] = new char[n];

		int freq[] = new int[26];
		for (int i = 0; i < n; ++i)
			freq[a[i] - 'a']++;

		for (int i = 1; i < 26; i++)
			freq[i] += freq[i - 1];

		for (int i = n - 1; i >= 0; --i)
		{
			output[freq[a[i] - 'a'] - 1] = a[i];
			freq[a[i] - 'a']--;
		}

		for (int i = 0; i < n; ++i)
			a[i] = output[i];
	}

	public static void main(String[] args)
	{
		char a[] = { 'a', 'n', 'a', 'n', 'd', 'k', 'u', 'm', 'a', 'r' };
		sort(a);
		System.out.print(Arrays.toString(a));
	}

}

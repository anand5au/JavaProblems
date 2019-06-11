package problems;

import java.util.Scanner;

public class Pangram
{
	static void isPangram(String s)
	{
		if (s == null || s.isEmpty())
			return;

		int[] freq = new int[26];
		int len = s.length();
		for (int i = 0; i < len; i++)
		{
			char c = s.charAt(i);
			if (c < 'a' || c > 'z')
				continue;
			freq[c - 'a']++;
		}

		int count = freq[0];
		for (int i = 0; i < 26; i++)
		{
			if (count == 0)
			{
				System.out.println("not pangram");
				return;
			}
			else if (count != freq[i])
			{
				System.out.println("pangram");
				return;
			}
		}
		System.out.println("multiple pangram " + count);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		isPangram(s.toLowerCase());
		sc.close();
	}
}

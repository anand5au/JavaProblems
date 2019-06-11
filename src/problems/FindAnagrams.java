package problems;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams
{
	static List<Integer> findAnagrams(String s, String p)
	{
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;

		int[] freq = new int[256];

		for (char c : p.toCharArray())
			freq[c]++;

		int left = 0, right = 0, count = p.length();
		while (right < s.length())
		{
			if (freq[s.charAt(right)] >= 1)
				count--;
			freq[s.charAt(right)]--;
			right++;

			if (count == 0)
				list.add(left);

			if (right - left == p.length())
			{
				// if we are throwing away a valid char, increase the count
				// a char is valid if it occurs in p
				if (freq[s.charAt(left)] >= 0)
					count++;
				// restore the count of left most char before throwing it away
				freq[s.charAt(left)]++;
				left++;
			}
		}
		return list;
	}

	public static void main(String[] args)
	{
		// System.out.println(findAnagrams("abab", "ab"));
		System.out.println(findAnagrams("caababaaaa", "aaba"));
		// System.out.println(findAnagrams("bbbbcacaa", "aaba"));
	}

}

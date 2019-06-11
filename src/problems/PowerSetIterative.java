package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSetIterative
{
	static ArrayList<String> buildSubsequences(String s)
	{
		ArrayList<String> subsequence = new ArrayList<String>();
		int len = s.length();
		for (int i = 0; i < len; i++)
		{
			if (subsequence.size() > 0)
			{
				int l = subsequence.size();
				for (int j = 0; j < l; j++)
					subsequence.add(subsequence.get(j) + s.charAt(i));
			}
			subsequence.add(s.charAt(i) + "");
		}

		return subsequence;
	}

	public static void main(String[] args)
	{
		ArrayList<String> arr = buildSubsequences("abba");
		System.out.println(Arrays.toString(arr.toArray(new String[0])));
	}
}

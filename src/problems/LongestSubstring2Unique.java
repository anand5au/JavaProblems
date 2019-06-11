package problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring2Unique
{

	static String findLongestSubstring(String input)
	{
		if (input == null || input.length() == 0)
			return input;
		int len = input.length();
		int globalStart = 0, localStart = 0;
		int maxLen = Integer.MIN_VALUE, currLen = 0;
		char lastChar = 0, lastCharCount = 0;
		/*
		 * HashSet stores 2 unique characters seen so far
		 */
		Set<Character> uniqueChars = new HashSet<Character>();
		for (int i = 0; i < len; i++)
		{
			char c = input.charAt(i);
			/*
			 * if the HashSet contains the current character, then increase the
			 * running length.
			 */
			if (uniqueChars.contains(c))
			{
				currLen++;
			}
			else
			{
				/*
				 * if the current character is a new character, then add it to
				 * HashSet.
				 */
				if (uniqueChars.size() < 2)
				{
					uniqueChars.add(c);
					currLen++;
				}
				/*
				 * If the new character is 3rd unique character, then update the
				 * HashSet, globalStart and maxLen accordingly.
				 */
				else
				{
					uniqueChars.clear();
					uniqueChars.add(lastChar);
					uniqueChars.add(c);
					if (maxLen < currLen)
					{
						maxLen = currLen;
						globalStart = localStart;
						currLen = lastCharCount + 1;
						localStart = i - lastCharCount;
					}
				}
			}
			if (c != lastChar)
			{
				lastChar = c;
				lastCharCount = 0;
			}
			lastCharCount++;
		}
		/*
		 * include the character at end of the string to our running length and
		 * global length if needed.
		 */
		if (maxLen < currLen)
		{
			maxLen = currLen;
			globalStart = localStart;
		}
		return input.substring(globalStart, globalStart + maxLen);
	}

	public static void main(String[] args)
	{
		System.out.println(findLongestSubstring("aabaaaccacccadef"));
	}

}

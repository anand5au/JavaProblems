package problems;

public class LongestPalindromicChunks
{
	static int longestPalindrome(String s)
	{
		if (s.length() == 0)
			return 0;

		int inpLen = s.length();
		int start = 0, end = inpLen, chunkCount = 0, matchedLen = 0;

		for (int i = 1; i <= inpLen / 2; i++)
		{
			if (s.substring(start, i).equals(s.substring(inpLen - i, end)))
			{
				chunkCount += 2;
				int len = s.substring(start, i).length();
				matchedLen += (2 * len);
				start += len;
				end -= len;
			}
		}
		if (matchedLen < inpLen)
			chunkCount++;
		return chunkCount;
	}

	public static void main(String args[])
	{
		System.out.println(longestPalindrome("antaprezatepzapreanta"));
		System.out.println(longestPalindrome("merchant"));
		System.out.println(longestPalindrome("volvo"));
		System.out.println(longestPalindrome("ghiabcdefhelloadamhelloabcdefghi"));

	}
}

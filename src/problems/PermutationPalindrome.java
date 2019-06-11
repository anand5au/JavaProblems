package problems;

public class PermutationPalindrome
{
	public static boolean isPermPalindrome(String s)
	{
		int bitVector = 0;
		for (char c : s.toCharArray())
			bitVector = bitVector ^ (1 << (c - 'a'));
		// System.out.println(Integer.toBinaryString(bitVector) + " " +
		// Integer.toBinaryString(bitVector - 1));
		return (bitVector & (bitVector - 1)) == 0;
	}

	public static void main(String[] args)
	{
		System.out.println(isPermPalindrome("Tactooca".toLowerCase()));
	}

}

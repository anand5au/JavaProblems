package problems;

import java.util.Stack;

public class RemoveMatchingPairs
{

	boolean isUpper(char c)
	{
		return (c >= 'A' && c <= 'Z');
	}

	boolean isLower(char c)
	{
		return (c >= 'a' && c <= 'z');
	}

	boolean equalsIgnoreCase(char upper, char lower)
	{
		return (lower - upper == 32);
	}

	int findMatchingPair(String input)
	{
		Stack<Character> st = new Stack<Character>();
		int len = input.length();
		int retValue = -1;
		for (int i = 0; i < len; i++)
		{
			char c = input.charAt(i);
			if (isUpper(c))
			{
				st.push(c);
			}
			else
			{
				if (!st.empty() && equalsIgnoreCase(st.peek(), c))
				{
					retValue = i;
					st.pop();
				}
				else
				{
					return retValue;
				}
			}
		}
		return retValue;
	}

	public static void main(String[] args)
	{

	}

}

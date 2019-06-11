package problems;

import java.util.Scanner;

public class StrobogrammaticNumber
{
	public static boolean isStrobogrammatic(String n)
	{
		if (n == null || n.isEmpty())
			return false;
		int start = 0, end = n.length() - 1;
		while (start <= end)
		{
			if (n.charAt(start) == n.charAt(end))
			{
				if (isStrobo(n.charAt(start)))
				{
					start++;
					end--;
				}
				else
				{
					return false;
				}
			}
			else
			{
				if (n.charAt(start) == '6' && n.charAt(end) == '9' || n.charAt(start) == '9' && n.charAt(end) == '6')
				{
					start++;
					end--;
				}
				else
				{
					return false;
				}
			}
		}
		return true;
	}

	static boolean isStrobo(char c)
	{
		return (c == '8' || c == '0' || c == '1');
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		sc.close();
		System.out.println(isStrobogrammatic(n));
	}
}

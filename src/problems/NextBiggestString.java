package problems;

import java.util.LinkedList;
import java.util.Queue;

public class NextBiggestString
{
	public static String findNextBiggest(String in)
	{
		int len = in.length();
		int i = len - 1;
		char temp = 0;
		StringBuilder sb = new StringBuilder(in);
		StringBuilder sb1 = new StringBuilder();
		Queue<Character> queue = new LinkedList<Character>();
		for (; i > 0; i--)
		{
			char a = in.charAt(i);
			char b = in.charAt(i - 1);
			if (a <= b)
			{
				queue.add(a);
				continue;
			}
			queue.add(a);

			System.out.println("queue " + queue.toString());

			temp = queue.poll();
			while (temp <= b)
			{
				sb1.append(temp);
				temp = queue.poll();
			}
			System.out.println("sb1: " + sb1.toString());
			sb.setCharAt(i - 1, temp);
			sb1.append(b);

			while (!queue.isEmpty())
				sb1.append(queue.poll());
			break;
		}
		System.out.println("sb1: " + sb1.toString());
		sb.setLength(i);
		return sb.append(sb1).toString();
	}

	public static void main(String args[])
	{
		String s = findNextBiggest("abcdeedcba");
		System.out.println(s);
	}
}

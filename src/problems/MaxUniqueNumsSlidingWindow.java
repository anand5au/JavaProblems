package problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxUniqueNumsSlidingWindow
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = 0;

		for (int i = 0; i < n; i++)
		{
			int num = sc.nextInt();
			deque.offer(num);
			if (map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);

			if (deque.size() > m)
			{
				int head = deque.poll();
				if (map.get(head) > 1)
					map.put(head, map.get(num) - 1);
				else
					map.remove(head);
			}
			max = Math.max(max, map.size());
		}
		System.out.println(max);
		sc.close();
	}
}

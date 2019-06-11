package problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyPriorityQueue
{
	public static void main(String[] args)
	{
		Comparator<Integer> comp = new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o2 - o1;
			}
		};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);
		pq.add(7);
		pq.add(8);
		pq.add(5);
		pq.add(9);
		while (pq.size() > 0)
			System.out.println(pq.poll());
	}
}

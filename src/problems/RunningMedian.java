package problems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), a = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n / 2 + 1);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n / 2 + 1), Collections.reverseOrder());
		double median = 0;
		for (int i = 0; i < n; i++)
		{
			a = sc.nextInt();
			if (a > median)
			{
				if (maxHeap.size() < minHeap.size())
					maxHeap.add(minHeap.poll());
				minHeap.add(a);
				median = minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
			}
			else
			{
				if (minHeap.size() < maxHeap.size())
					minHeap.add(maxHeap.poll());
				maxHeap.add(a);
				median = minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : maxHeap.peek();
			}
			System.out.println(median);
		}
		sc.close();
	}
}

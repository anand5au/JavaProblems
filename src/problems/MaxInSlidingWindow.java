package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxInSlidingWindow
{
	public static void printMaxInSlidingWindow(int[] a, int n, int k)
	{
		if (a == null || a.length == 0)
			return;

		Deque<Integer> deq = new ArrayDeque<Integer>();
		int idx = 0;
		for (; idx < k; idx++)
		{
			while (!deq.isEmpty() && a[idx] >= a[deq.peekLast()])
				deq.pollLast();
			deq.offer(idx);
		}

		for (; idx < n; idx++)
		{
			System.out.print(a[deq.peek()] + " ");

			// Reason for storing indices in deque:
			// since index is used here to delete old elements from window.
			if (!deq.isEmpty() && deq.peek() <= (idx - k))
				deq.poll();

			while (!deq.isEmpty() && a[idx] >= a[deq.peekLast()])
				deq.pollLast();
			deq.offer(idx);
		}
		if (!deq.isEmpty())
			System.out.print(a[deq.peek()]);
	}

	public static void understandDeque(int[] a, int n)
	{
		Deque<Integer> deq = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++)
		{
			deq.offer(a[i]);
			System.out.println(deq);
		}
		System.out.println("peekFirst: " + deq.peekFirst());
		System.out.println("peek: " + deq.peek());
		System.out.println("peekLast: " + deq.peekLast());
		System.out.println("poll: " + deq.poll());
		System.out.println("pollLast: " + deq.pollLast());
		System.out.println(deq);
		deq.offer(100);
		System.out.println(deq);
	}

	public static void main(String[] args)
	{
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// int k = sc.nextInt();
		// int[] a = new int[n];
		int[] a = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
		// for (int i = 0; i < n; i++)
		// a[i] = sc.nextInt();
		printMaxInSlidingWindow(a, 10, 3);
		// understandDeque(a, 10);
		// sc.close();
	}

}

package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists
{
	public static ListNode<Integer> Merge(ArrayList<ListNode<Integer>> lists)
	{
		if (lists == null || lists.isEmpty())
			return null;

		PriorityQueue<ListNode<Integer>> minheap = new PriorityQueue<ListNode<Integer>>(lists.size(),
				new Comparator<ListNode<Integer>>()
				{
					@Override
					public int compare(ListNode<Integer> o1, ListNode<Integer> o2)
					{
						return o1.data - o2.data;
					}
				});

		for (ListNode<Integer> list : lists)
			minheap.add(list);

		ListNode<Integer> head = minheap.poll();
		ListNode<Integer> end = head;

		while (!minheap.isEmpty())
		{
			if (end.next != null)
				minheap.add(end.next);

			end.next = minheap.poll();
			end = end.next;
		}

		return head;
	}

	public static void main(String args[])
	{
		ArrayList<ListNode<Integer>> lists = new ArrayList<ListNode<Integer>>();
		MyLinkedList<Integer> l1 = new MyLinkedList<Integer>();
		l1.insertAtEnd(10);
		l1.insertAtEnd(12);
		l1.insertAtEnd(13);
		l1.insertAtEnd(15);
		lists.add(l1.head);
		l1.printList();

		MyLinkedList<Integer> l2 = new MyLinkedList<Integer>();
		l2.insertAtEnd(1);
		l2.insertAtEnd(5);
		l2.insertAtEnd(6);
		l2.insertAtEnd(8);
		lists.add(l2.head);
		l2.printList();

		MyLinkedList<Integer> l3 = new MyLinkedList<Integer>();
		l3.insertAtEnd(2);
		l3.insertAtEnd(3);
		l3.insertAtEnd(4);
		l3.insertAtEnd(9);
		lists.add(l3.head);
		l3.printList();

		MyLinkedList<Integer> l4 = new MyLinkedList<Integer>();
		l4.insertAtEnd(7);
		l4.insertAtEnd(11);
		l4.insertAtEnd(14);
		l4.insertAtEnd(16);
		lists.add(l4.head);
		l4.printList();

		MyLinkedList<Integer> l5 = new MyLinkedList<Integer>();
		l5.head = Merge(lists);
		l5.printList();
	}
}

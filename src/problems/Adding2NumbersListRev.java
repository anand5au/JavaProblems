package problems;

public class Adding2NumbersListRev
{

	public static MyLinkedList<Integer> addLists(MyLinkedList<Integer> l1, MyLinkedList<Integer> l2)
	{
		if (l1 == null && l2 == null)
			return null;

		ListNode<Integer> t1 = (l1 != null) ? l1.getHead() : null;
		ListNode<Integer> t2 = (l2 != null) ? l2.getHead() : null;

		MyLinkedList<Integer> l3 = new MyLinkedList<Integer>();

		int sum = 0, carry = 0;

		while (t1 != null && t2 != null)
		{
			sum = (t1.data + t2.data + carry);
			carry = sum / 10;
			l3.insertAtEnd(sum % 10);
			t1 = t1.next;
			t2 = t2.next;
		}

		while (t1 != null)
		{
			sum = t1.data + carry;
			l3.insertAtEnd(sum % 10);
			carry = sum / 10;
			t1 = t1.next;
		}

		while (t2 != null)
		{
			sum = t2.data + carry;
			l3.insertAtEnd(sum % 10);
			carry = sum / 10;
			t2 = t2.next;
		}

		if (carry > 0)
			l3.insertAtEnd(carry);

		return l3;

	}

	public static void main(String[] args)
	{
		 MyLinkedList<Integer> l1 = new MyLinkedList<Integer>();
		 l1.insertAtEnd(7);
		 l1.insertAtEnd(1);
		 l1.insertAtEnd(6);
		 l1.printList();

		MyLinkedList<Integer> l2 = new MyLinkedList<Integer>();
		l2.insertAtEnd(5);
		l2.insertAtEnd(9);
		l2.insertAtEnd(5);
		l2.printList();

		MyLinkedList<Integer> l3 = addLists(l1, l2);
		if (l3 != null)
			l3.printList();
	}
}

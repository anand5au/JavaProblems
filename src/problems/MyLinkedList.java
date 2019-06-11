package problems;

class ListNode<T>
{
	public T data;
	public ListNode<T> next;

	public ListNode()
	{
		next = null;
	}

	public ListNode(T d)
	{
		data = d;
		next = null;
	}
}

class RandomListNode
{
	int label;
	RandomListNode next, random;

	RandomListNode(int x)
	{
		this.label = x;
	}
};

public class MyLinkedList<T>
{
	ListNode<T> head;
	ListNode<T> tail;

	public MyLinkedList()
	{
		head = null;
		tail = null;
	}

	public ListNode<T> getHead()
	{
		return head;
	}

	public void setHead(ListNode<T> h)
	{
		head = h;
	}

	public ListNode<T> getTail()
	{
		return tail;
	}

	public int length()
	{
		ListNode<T> t = head;
		int len = 0;
		while (t != null)
		{
			len++;
			t = t.next;
		}

		return len;
	}

	void insertAtStart(T d)
	{
		ListNode<T> newNode = new ListNode<T>(d);

		if (head != null)
			newNode.next = head;
		else
			tail = newNode;
		head = newNode;
	}

	void insertAtEnd(T d)
	{
		ListNode<T> newNode = new ListNode<T>(d);

		if (head == null)
			head = newNode;
		else
			tail.next = newNode;
		tail = newNode;
	}

	void printList()
	{
		if (head == null)
			return;

		ListNode<T> node = head;
		while (node != null)
		{
			System.out.print(node.data);
			if (node.next != null)
				System.out.print("->");
			node = node.next;
		}
		System.out.println();
	}

	ListNode<T> reverseList(ListNode<T> head)
	{
		if (head == null || head.next == null)
			return head;

		ListNode<T> node = head;
		ListNode<T> prev = null;

		while (node != null)
		{
			ListNode<T> next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}

		return prev;
	}

	void reverseList()
	{
		ListNode<T> curr = head;
		ListNode<T> prev = null;
		ListNode<T> next = null;

		while (curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
	}

}

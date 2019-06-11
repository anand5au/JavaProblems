package problems;

import java.util.HashMap;
import java.util.Map;

public class LinkedListRandPtr
{
	public RandomListNode copyRandomList(RandomListNode head)
	{
		if (head == null)
			return null;

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode temp = head;

		while (temp != null)
		{
			RandomListNode node = new RandomListNode(temp.label);
			map.put(temp, node);
			temp = temp.next;
		}

		RandomListNode cpy_temp = null;
		temp = head;
		while (temp != null)
		{
			cpy_temp = map.get(temp);
			cpy_temp.next = map.get(temp.next);
			cpy_temp.random = map.get(temp.random);
			temp = temp.next;
		}

		return map.get(head);
	}

	public static void main(String[] args)
	{

	}

}

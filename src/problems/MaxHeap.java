package problems;

public class MaxHeap
{
	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MaxHeap(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MAX_VALUE;
	}

	private int parent(int pos)
	{
		return pos / 2;
	}

	private int leftChild(int pos)
	{
		return (2 * pos);
	}

	private boolean isLeaf(int pos)
	{
		if (pos > (size / 2) && pos <= size)
		{
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos)
	{
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	private void maxHeapify(int pos)
	{
		while (!isLeaf(pos))
		{
			int newPos = leftChild(pos);
			if ((newPos < size) && Heap[newPos + 1] > Heap[newPos])
				newPos++; // move to right child
			if (Heap[newPos] < Heap[pos])
				break;
			swap(pos, newPos);
			pos = newPos;
		}
	}

	public void insert(int element)
	{
		Heap[++size] = element;
		int current = size;
		while (Heap[current] > Heap[parent(current)])
		{
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void maxHeap() // this function is just to form a maxheap from
							// existing array
	{
		for (int pos = (size / 2); pos >= 1; pos--)
			maxHeapify(pos);
	}

	public int remove()
	{
		int popped = Heap[FRONT];
		if (size == FRONT)
		{
			size--;
		}
		else
		{
			Heap[FRONT] = Heap[size--];
			maxHeapify(FRONT);
		}
		return popped;
	}

	public void removeAll()
	{
		while (size > 0)
			System.out.print(remove() + " ");
		System.out.println();
	}

	public static void main(String... arg)
	{
		System.out.println("The Max Heap is ");
		MaxHeap maxHeap = new MaxHeap(10);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);
		maxHeap.insert(100);

		maxHeap.removeAll();
	}
}

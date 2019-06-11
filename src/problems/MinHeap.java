package problems;

public class MinHeap
{
	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeap(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
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
		if (pos > (size / 2) && pos <= size) { return true; }
		return false;
	}

	private void swap(int fpos, int spos)
	{
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	private void minHeapify(int pos)
	{
		while(!isLeaf(pos))
		{
			int newPos = leftChild(pos);
			if((newPos < size) && Heap[newPos+1] < Heap[newPos])
				newPos++; // move to right child
			if(Heap[newPos] > Heap[pos])
				break;
			swap(pos, newPos);
			pos = newPos;
		}
	}

	public void insert(int element)
	{
		Heap[++size] = element;
		int current = size;
		while (Heap[current] < Heap[parent(current)])
		{
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void minHeap() // this function is just to form a minheap from existing array 
	{
		for (int pos = (size / 2); pos >= 1; pos--)
		{
			minHeapify(pos);
		}
	}

	public int remove()
	{
		int popped = Heap[FRONT];
		if(size == FRONT)
		{
			Heap[size--] = Integer.MAX_VALUE;
		}
		else
		{	
			Heap[FRONT] = Heap[size];
			Heap[size--] = Integer.MAX_VALUE;
			minHeapify(FRONT);
		}
		
		return popped;
	}
	
	public void removeAll()
	{
		while(size>0)
			System.out.print(remove()+" ");
		System.out.println();
	}
	
	public static void main(String... arg)
	{
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(10);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		minHeap.insert(100);
		
		minHeap.removeAll();
		
	}
}
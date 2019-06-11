package problems;

public class ArrayRearrange
{
	public static void swap(int a[], int head, int tail)
	{
		int c = a[head];
		a[head] = a[tail];
		a[tail] = c;
	}

	public static void printArray(int a[])
	{
		int length = 0;
		while (length < a.length)
		{
			System.out.print(a[length] + " ");
			length++;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int a[] = { -1, 0, -2, 0, 6, -5, 0, -3, -4 };

		int head = 0, pass = 0;
		while (pass < 2)
		{
			int tail = a.length - 1;
			while (head <= tail)
			{
				if (pass > 0 ? (a[head] == 0) : (a[head] < 0))
				{
					head++;
					continue;
				}
				else
				{
					if (pass > 0 ? (a[tail] == 0) : (a[tail] < 0))
					{
						swap(a, head, tail);
						head++;
					}
					tail--;
				}
			}
			pass++;
			System.out.println(head + " " + tail);
			printArray(a);
		}
	}
}

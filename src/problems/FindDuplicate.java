package problems;

public class FindDuplicate
{
	static int findDuplicate(int[] nums)
	{
		int l = 1, r = nums.length - 1;

		while (l < r)
		{
			int m = l + (r - l) / 2;
			int count = 0;

			for (int a : nums)
			{
				if (a <= m)
					count++;
			}

			// System.out.println("mid: " + m + " count: " + count);
			if (count > m)
				r = m;
			else
				l = m + 1;
		}
		return l;
	}

	static int findDuplicateFast(int[] nums)
	{
		/*
		 * since the array contains numbers only between [1..N], the array will
		 * have atleast one cycle. starting at 0 is the key. since the array has
		 * no 0, the cycle we encounter starting at 0 will not be based on the
		 * number at 0th index, i.e. it will definitely contain the duplicate
		 * element, which will be the starting node of cycle.
		 */
		int slow = nums[0], fast = nums[slow];

		while (slow != fast)
		{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		slow = 0;
		while (fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}

	public static void main(String args[])
	{
		int a[] = { 4, 1, 3, 2, 6, 7, 5, 1 };
		System.out.println(findDuplicateFast(a));
	}

}

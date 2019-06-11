package problems;

import java.util.Arrays;

public class WiggleSort
{
	static void wiggleSort(int[] nums)
	{
		for (int i = 1; i < nums.length; i++)
		{
			int a = nums[i - 1];
			if ((i % 2 == 1) == (a > nums[i]))
			{
				nums[i - 1] = nums[i];
				nums[i] = a;
			}
		}
	}

	public static void main(String[] args)
	{
		int[] nums = { 1, 1, 1, 4, 5, 6 };
		wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}

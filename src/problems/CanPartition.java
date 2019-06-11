package problems;

import java.util.Arrays;

public class CanPartition
{
	static boolean canPartition(int[] nums)
	{
		if (nums == null || nums.length < 2)
			return false;

		int target = 0;
		for (int i : nums)
			target += i;

		if ((target & 1) == 1)
			return false;

		target /= 2;
		boolean[] part = new boolean[target + 1];
		part[0] = true;
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = nums[i]; j <= target; j++)
				part[j] = part[j] || part[j - nums[i]];
			System.out.println(Arrays.toString(part));
		}
		return part[target];
	}

	public static void main(String[] args)
	{
		int[] a = { 4, 5, 3, 2 };
		System.out.println(canPartition(a));
	}

}

package problems;

import java.util.Arrays;

public class MaxSumSubarray
{
	static int maxSumSubSeq(int[] nums)
	{
		int globalMax = nums[0];
		int len = nums.length;
		for (int i = 1; i < len; i++)
			globalMax = Math.max(nums[i], Math.max(globalMax, globalMax + nums[i]));
		return globalMax;
	}

	static int maxSumSubArray(int[] nums)
	{
		int localMax = nums[0];
		int globalMax = nums[0];
		int len = nums.length;
		for (int i = 1; i < len; i++)
		{
			localMax = Math.max(nums[i], localMax + nums[i]);
			globalMax = Math.max(globalMax, localMax);
		}
		return globalMax;
	}

	static void maxSubArray(int[] nums)
	{
		int localMax = nums[0];
		int globalMax = nums[0];
		int localStart = 0, globalStart = 0, globalEnd = 0;
		int len = nums.length;
		for (int i = 1; i < len; i++)
		{
			if (localMax + nums[i] > nums[i])
			{
				localMax += nums[i];
			}
			else
			{
				localMax = nums[i];
				localStart = i;
			}

			if (globalMax < localMax)
			{
				globalMax = localMax;
				globalStart = localStart;
				globalEnd = i;
			}
		}
		System.out.println("start: " + globalStart + " end: " + globalEnd);
	}

	public static void main(String[] args)
	{
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -9, 4 };
		System.out.println(Arrays.toString(a));
		System.out.println("Max sum of subarray: " + maxSumSubArray(a));
		maxSubArray(a);
		System.out.println("Max sum of subsequence: " + maxSumSubSeq(a));
	}
}

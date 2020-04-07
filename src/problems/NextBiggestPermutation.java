package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NextBiggestPermutation
{
	public static void findNextBiggest(int[] nums)
	{
		int pivot = nums.length-1;
		for(; pivot > 0 && nums[pivot] <= nums[pivot-1]; pivot--);
		pivot--;

		if(pivot == -1) {
			reverse(nums, 0, nums.length-1);
		} else {
			int i=nums.length-1;
			for(; i>pivot && nums[i] <= nums[pivot]; i--);
			swap(nums, pivot, i);
			reverse(nums, pivot+1, nums.length-1);
		}
	}

	private static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			swap(nums, start++, end--);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String args[])
	{
		int[] nums = {6,4,2,5,4,3,3,2,1};
		findNextBiggest(nums);
		System.out.println(Arrays.toString(nums));
	}
}

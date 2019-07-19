package problems;

import java.util.Arrays;

public class FirstLastOccurence {
    private static int[] searchRange(int[] nums, int target) {
        int low = 0, high=nums.length-1;
        int result[] = new int[2];
        Arrays.fill(result, -1);
        while(high >= low) {
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid-1] < target) && nums[mid] == target) {
                result[0] = mid;
                break;
            }
            else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }

        low = 0;
        high=nums.length-1;
        while(high >= low) {
            int mid = low + (high - low)/2;
            if((mid == nums.length-1 || nums[mid+1] > target) && nums[mid] == target) {
                result[1] = mid;
                break;
            }
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
}

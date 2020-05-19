package problems;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Permutation
{
	/************************************ approach 1 ***************************************************/
	private static List<String> perm(String s) {
		if (s == null)
			return null;
		List<String> permList = new ArrayList<String>();
		if (s.isEmpty()) {
			permList.add("");
			return permList;
		}

		char first = s.charAt(0);
		String remaining = s.substring(1);
		List<String> inter = perm(remaining);
		for (String str : inter) {
			for (int i = 0; i <= str.length(); i++)
				permList.add(insertAt(str, first, i));
		}
		return permList;
	}

	private static String insertAt(String s, char c, int i) {
		return (s.substring(0, i) + c + s.substring(i));
	}

	/************************************ approach 2 ***************************************************/
	private static ArrayList<String> getPerms(String s) {
		ArrayList<String> result = new ArrayList<>();
		getPerms("", s, result);
		return result;
	}

	private static void getPerms(String prefix, String rem, ArrayList<String> result) {
		if (rem.length() == 0)
			result.add(prefix);

		int len = rem.length();
		for (int i = 0; i < len; i++) {
			String before = rem.substring(0, i);
			String after = rem.substring(i + 1);
			char c = rem.charAt(i);
			getPerms(prefix + c, before + after, result);
		}
	}

	/************************************ Permutation of array (similar to approach 1) ***************************************************/
	public List<List<Integer>> permute(int[] nums) {
		return permute(nums, 0);
	}

	private List<List<Integer>> permute(int[] nums, int index) {
		List<List<Integer>> result = new ArrayList<>();

		if(index == nums.length) {
			result.add(new ArrayList<Integer>());
			return result;
		}

		int first = nums[index++];
		List<List<Integer>> remainingPermuted = permute(nums, index);

		for(List<Integer> list : remainingPermuted) {
			for(int i=0; i<=list.size(); i++) {
				List<Integer> temp = new ArrayList<>(list);
				temp.add(i, first);
				result.add(temp);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String a = "abcd";
		System.out.println(perm(a));
	}

}

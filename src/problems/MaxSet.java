package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxSet
{
	public static boolean AddToSet(int[] A, int[] B, int i, int temp)
	{
		if (B[i] > 0)
			return false;
		B[i] = temp++;
		boolean ret = AddToSet(A, B, A[i], temp);
		return ret;
	}

	public static int solution(int A[], int N)
	{
		if (A.length == 0)
			return 0;
		int[] B = new int[N];
		Set<Integer> set = new HashSet<Integer>();
		int totalSize = 0;
		for (int i = 0; i < N; i++)
		{
			if (B[i] > 0)
				continue;

			while (AddToSet(A, B, i, 1));
			System.out.println(set);
			System.out.println(Arrays.toString(B));

			totalSize += set.size();
			System.out.println(totalSize);
			if (totalSize >= N)
				break;
			set.clear();
		}

		int max = -1;
		for (int i = 0; i < B.length; i++)
		{
			if (B[i] > max)
				max = B[i];
		}
		return max;
	}

	public static void main(String[] args)
	{
		int A[] = { 5, 4, 1, 0, 3, 6, 2 };
		// int A[] = {5,4,0,3,1,6,2};
		// int A[] = {0,1,2,3,4,5,6};
		System.out.println(solution(A, A.length));
	}
}

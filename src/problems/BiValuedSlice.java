package problems;

import java.util.*;

public class BiValuedSlice
{
	public static int solution(int[] A)
	{
		int idx = 0, numCount = 0;
		Set<Integer> visited = new HashSet<Integer>();

		while (idx < A.length)
		{
			int tmp = 0;
			for (int i = idx; i < A.length; i++)
			{
				visited.add(A[i]);
				if (visited.size() == 3)
				{
					visited.clear();
					if (tmp > numCount)
						numCount = tmp;
					break;
				}
				tmp++;
			}
			idx++;
		}
		return numCount;
	}

	public static void main(String[] args)
	{
	}

}

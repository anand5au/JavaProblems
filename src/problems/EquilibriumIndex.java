package problems;

public class EquilibriumIndex
{
	public static int solution(int[] a)
	{
		long sumL = 0, sumR = 0;
		int len = a.length;
		for (int i = 0; i < len; i++)
			sumR += a[i];
		for (int i = 0; i < len; i++)
		{
			sumR -= a[i];
			if (sumL == sumR)
				return i;
			sumL += a[i];
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] a = { -1, 3, -4, 5, 1, -6, 2, 1 };
		System.out.println(solution(a));

	}

}

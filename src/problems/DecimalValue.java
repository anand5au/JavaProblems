package problems;

public class DecimalValue
{
	public static void main(String[] args)
	{
		int[][] input = { { 0, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int max = 0;
		for (int i = 0; i < input.length; i++)
		{
			int tmp = 0;
			for (int j = input[i].length - 1; j >= 0; j--)
			{
				tmp |= (input[i][j] << (input[i].length - 1 - j));
				System.out.println(tmp);
			}
			if (tmp > max)
				max = tmp;
		}
		System.out.println("Max: " + max);
	}
}

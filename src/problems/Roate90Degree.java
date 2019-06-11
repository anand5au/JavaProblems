package problems;

public class Roate90Degree
{
	static int[][] rotateExtraSpace(int[][] a)
	{
		int m = a.length, n = a[0].length;
		int[][] b = new int[n][m];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				b[j][m - i - 1] = a[i][j];
		return b;
	}

	// can be done only for sq matrix. ratate one number at a time
	static void rotateInPlace(int[][] a)
	{
		if (a.length == 0 || a.length != a[0].length)
			return;
		int n = a.length;
		for (int i = 0; i < n / 2; i++)
		{
			for (int j = i; j < n - 1 - i; j++)
			{
				int temp = a[i][j];
				a[i][j] = a[n - 1 - j][i];
				a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
				a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
				a[j][n - 1 - i] = temp;
			}
		}
	}

	static void printMatrix(int[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 9, 10, 11, 12 } };
		printMatrix(rotateExtraSpace(a));
		rotateInPlace(a);
		System.out.println();
		printMatrix(a);
	}

}

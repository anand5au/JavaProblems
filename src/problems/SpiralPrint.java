package problems;

public class SpiralPrint
{
	static void spiralPrint(int a[][])
	{
		int i, rowStart = 0, colStart = 0, rowEnd = a.length, colEnd = a[0].length;

		while (rowStart < rowEnd && colStart < colEnd)
		{
			for (i = colStart; i < colEnd; ++i)
				System.out.print(a[rowStart][i] + " ");
			rowStart++;

			for (i = rowStart; i < rowEnd; ++i)
				System.out.print(a[i][colEnd - 1] + " ");
			colEnd--;

			// to prevent printing first row again in case of single row matrix
			if (rowStart < rowEnd)
			{
				for (i = colEnd - 1; i >= colStart; --i)
					System.out.print(a[rowEnd - 1][i] + " ");
				rowEnd--;
			}
			// to prevent printing first column again in case of single column
			// matrix
			if (colStart < colEnd)
			{
				for (i = rowEnd - 1; i >= rowStart; --i)
					System.out.print(a[i][colStart] + " ");
				colStart++;
			}
		}
	}

	static void spiralPrintReverse(int a[][])
	{
		int sr = a.length / 2, sc = sr, totalCount = (a.length * a[0].length);
		int leftInc = 1, rightInc = 2;
		int count = 0;
		while (count < totalCount)
		{
			for (int i = 0; i < leftInc; i++)
			{
				System.out.print(a[sr][sc--] + " ");
				count++;
			}
			for (int i = 0; i < leftInc && count < totalCount; i++)
			{
				System.out.print(a[sr--][sc] + " ");
				count++;
			}

			for (int i = 0; i < rightInc && count < totalCount; i++)
			{
				System.out.print(a[sr][sc++] + " ");
				count++;
			}
			for (int i = 0; i < rightInc && count < totalCount; i++)
			{
				System.out.print(a[sr++][sc] + " ");
				count++;
			}
			leftInc += 2;
			rightInc += 2;
		}
	}

	public static void main(String[] args)
	{
		int[][] a = { { 1, 2 }, { 1, 2 } };
		spiralPrint(a);
		System.out.println();
		spiralPrintReverse(a);
	}
}

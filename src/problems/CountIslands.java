package problems;

public class CountIslands
{
	static int[] rowNum = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] colNum = { 0, -1, 1, -1, 1, -1, 1, 0 };

	static void merge(char[][] grid, int i, int j)
	{
		int m = grid.length, n = grid[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')
			return;

		grid[i][j] = 'X';

		for (int a = 0; a < rowNum.length; a++)
			merge(grid, i + rowNum[a], j + colNum[a]);
	}

	public static int numIslands(char[][] grid)
	{
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length, n = grid[0].length, count = 0;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (grid[i][j] == '1')
				{
					count++;
					merge(grid, i, j);
				}
			}
		}
		return count;
	}

	public static void main(String[] args)
	{
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '0', '1', '0', '0', '1' }, { '1', '0', '0', '1', '1' },
				{ '0', '0', '0', '0', '0' }, { '1', '0', '1', '0', '1' } };
		System.out.println(numIslands(grid));
	}

}

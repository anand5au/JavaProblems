package problems;

import java.util.LinkedList;
import java.util.Queue;

class MazeNode
{
	int x;
	int y;

	public MazeNode(int a, int b)
	{
		x = a;
		y = b;
	}
}

class QueueNode
{
	MazeNode a;
	int dist;

	public QueueNode(MazeNode a, int dist)
	{
		this.a = a;
		this.dist = dist;
	}
}

public class ShortestPathBinaryMaze
{
	static boolean isValid(int x, int y, int rows, int cols)
	{
		if (x >= 0 && y >= 0 && x < rows && y < cols)
			return true;
		return false;
	}

	static int shortestPath(int[][] maze, MazeNode src, MazeNode dst)
	{
		if (maze[src.x][src.y] == 0 || maze[dst.x][dst.y] == 0)
			return -1;

		int rows = maze.length, cols = maze[0].length;
		int adjX[] = {-1, 0, 1, 0}, adjY[] = {0, -1, 0, 1};
		Queue<QueueNode> q = new LinkedList<QueueNode>();
		boolean[][] visited = new boolean[rows][cols];
		q.offer(new QueueNode(src, 0));
		visited[src.x][src.y] = true;
		while (!q.isEmpty())
		{
			QueueNode temp = q.poll();
			if (temp.a.x == dst.x && temp.a.y == dst.y)
				return temp.dist;
			
			for (int i = 0; i < 4; i++)
			{
				int tempX = temp.a.x + adjX[i];
				int tempY = temp.a.y + adjY[i];
				
				if (isValid(tempX, tempY, rows, cols) && !visited[tempX][tempY] && maze[tempX][tempY] > 0)
				{
					q.offer(new QueueNode(new MazeNode(tempX, tempY), temp.dist + 1));
					visited[tempX][tempY] = true;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int maze[][] = 
		{ 
			{ 1, 0, 1, 1, 0, 1, 1, 1, 1, 1 }, 
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
			{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } 
		};
		System.out.println(shortestPath(maze, new MazeNode(0, 0), new MazeNode(0, 6)));
	}
}

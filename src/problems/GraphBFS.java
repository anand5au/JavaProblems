package problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphBFS
{
	public static void printReach(Graph g, int v, int st)
	{
		int reach[] = new int[v + 1];
		boolean visited[] = new boolean[v + 1];
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(st);
		visited[st] = true;
		int level = 1, currNodeCount = 1, newNodeCount = 0;
		while (!q.isEmpty())
		{
			int s = q.poll();
			currNodeCount--;
			Iterator<Integer> it = g.adj[s].iterator();
			while (it.hasNext())
			{
				int n = it.next();
				if (!visited[n])
				{
					reach[n] += (6 * level);
					visited[n] = true;
					q.offer(n);
					newNodeCount++;
				}
			}
			if (currNodeCount == 0)
			{
				level++;
				currNodeCount = newNodeCount;
				newNodeCount = 0;
			}
		}
		for (int i = 1; i <= v; i++)
		{
			if ((i != st))
			{
				if (reach[i] != 0)
					System.out.print(reach[i] + " ");
				else if (reach[i] == 0)
					System.out.print("-1 ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int i = 0; i < q; i++)
		{
			int v = sc.nextInt();
			Graph g = new Graph(v);
			int e = sc.nextInt();
			for (int j = 0; j < e; j++)
				g.addEdge(sc.nextInt(), sc.nextInt());
			int st = sc.nextInt();
			printReach(g, v, st);
		}
		sc.close();
	}
}

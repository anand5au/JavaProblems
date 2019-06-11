package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Edge
{
	int dest;
	int weight;

	public Edge(int d, int w)
	{
		dest = d;
		weight = w;
	}
}

class DG
{
	int v;
	List<Edge>[] adj;
	static int freq[];
	static boolean vis[];

	@SuppressWarnings("unchecked")
	public DG(int v)
	{
		this.v = v;
		adj = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++)
			adj[i] = new ArrayList<Edge>();
		freq = new int[10];
		vis = new boolean[v + 1];
	}

	public void addEdge(int a, int b, int w)
	{
		Edge e = new Edge(b, w);
		adj[a].add(e);
		e = new Edge(a, 1000 - w);
		adj[b].add(e);
	}

	public void findAllPaths()
	{
		for (int i = 1; i <= v; i++)
		{
			vis = new boolean[v + 1];
			Set<Integer> proc = new HashSet<Integer>();
			findAllPaths(i, i, 0, proc);
		}
		for (int i = 0; i < 10; i++)
			System.out.println(freq[i]);
	}

	public void findAllPaths(int src, int curr, int w, Set<Integer> proc)
	{
		vis[curr] = true;
		for (Edge e : adj[curr])
		{
			if (e.dest == src || e.dest == curr || proc.contains(e.dest))
				continue;
			// System.out.println(w + e.weight);
			freq[(w + e.weight) % 10]++;
			proc.add(e.dest);
			if (!vis[e.dest])
				findAllPaths(src, e.dest, w + e.weight, proc);
			if (curr == src)
			{
				proc.clear();
				vis = new boolean[v + 1];
			}
		}
	}
}

public class FindAllPathsDG
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		DG g = new DG(n);
		int e = in.nextInt();
		for (int a0 = 0; a0 < e; a0++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			int r = in.nextInt();
			g.addEdge(x, y, r);
		}
		g.findAllPaths();
		in.close();
	}
}

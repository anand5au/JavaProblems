package problems;

public class GraphDFS
{
	static void DFSUtil(DirectedGraph g, int v, boolean[] visited)
	{
		visited[v] = true;
		System.out.print(v + " ");
		for (int neighbor : g.adj[v])
		{
			if (!visited[neighbor])
				DFSUtil(g, neighbor, visited);
		}
	}

	static void DFS(DirectedGraph g, int v)
	{
		boolean visited[] = new boolean[v];
		for (int i = 0; i < v; i++)
		{
			if (!visited[i])
				DFSUtil(g, i, visited);
		}
	}

	static void DFS(DirectedGraph g, int v, int n)
	{
		boolean visited[] = new boolean[v];
		if (!visited[n])
			DFSUtil(g, n, visited);
	}

	public static void main(String[] args)
	{
		DirectedGraph g = new DirectedGraph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Depth First Traversal");
		DFS(g, 6);
		System.out.println();
		System.out.println("Depth First Traversal from 5: ");
		DFS(g, 6, 5);
	}

}

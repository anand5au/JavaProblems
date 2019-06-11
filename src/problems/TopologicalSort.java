package problems;

import java.util.Stack;

public class TopologicalSort
{
	static void topologicalSortUtil(DirectedGraph g, int v, boolean[] visited, Stack<Integer> stack)
	{
		visited[v] = true;
		for (int n : g.adj[v])
		{
			if (!visited[n])
				topologicalSortUtil(g, n, visited, stack);
		}
		stack.push(v);
	}

	static void topologicalSort(DirectedGraph g, int v)
	{
		boolean visited[] = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < v; i++)
		{
			if (!visited[i])
				topologicalSortUtil(g, i, visited, stack);
		}

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	public static void main(String[] args)
	{
		DirectedGraph g = new DirectedGraph(6);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(1, 5);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);

		System.out.println("Topological Sort:");
		topologicalSort(g, 6);
	}
}

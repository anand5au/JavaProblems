package problems;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Graph
{
	int vCount;
	List<Integer>[] adj;

	public Graph()
	{}

	public Graph(int v)
	{
		vCount = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int a, int b)
	{
		adj[a].add(b);
		adj[b].add(a);
	}
}

class DirectedGraph extends Graph
{

	public DirectedGraph(int v)
	{
		super(v);
	}

	@Override
	public void addEdge(int a, int b)
	{
		adj[a].add(b);
	}

}

package problems;

import java.util.Arrays;

class KGraph
{
	class KEdge implements Comparable<KEdge>
	{
		int src, dst, weight;

		@Override
		public int compareTo(KEdge that)
		{
			return this.weight - that.weight;
		}
	}

	class KSubset
	{
		int parent, rank;
	}

	int V, E;
	KEdge[] edge;

	public KGraph(int v, int e)
	{
		V = v;
		E = e;
		edge = new KEdge[E];
		for (int i = 0; i < E; i++)
			edge[i] = new KEdge();
	}

	public int find(KSubset[] subset, int i)
	{
		if (subset[i].parent != i)
			subset[i].parent = find(subset, subset[i].parent);
		return subset[i].parent;
	}

	public void union(KSubset[] subset, int x, int y)
	{
		int xParent = find(subset, x);
		int yParent = find(subset, y);

		if (subset[xParent].rank < subset[yParent].rank)
		{
			subset[xParent].parent = yParent;
		}
		else if (subset[yParent].rank < subset[xParent].rank)
		{
			subset[yParent].parent = xParent;
		}
		else
		{
			subset[xParent].parent = yParent;
			subset[yParent].rank++;
		}
	}

	public void kruskalMST()
	{
		int i = 0;
		int e = 0;
		KEdge mst[] = new KEdge[E];
		for (i = 0; i < E; i++)
			mst[i] = new KEdge();

		Arrays.sort(edge);

		KSubset subset[] = new KSubset[V];
		for (i = 0; i < V; i++)
		{
			subset[i] = new KSubset();
			subset[i].parent = i;
			subset[i].rank = 0;
		}
		i = 0;
		while (e < V - 1)
		{
			KEdge curr_edge = edge[i++];

			int x = find(subset, curr_edge.src);
			int y = find(subset, curr_edge.dst);
			if (x != y)
			{
				mst[e++] = curr_edge;
				union(subset, x, y);
			}
		}

		for (i = 0; i < E; i++)
		{
			System.out.println("Edge " + mst[i].src + "-->" + mst[i].dst + " (" + mst[i].weight + ")");
		}
	}
}

public class KruskalMST
{
	public static void main(String[] args)
	{
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		KGraph graph = new KGraph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dst = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dst = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dst = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dst = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dst = 3;
		graph.edge[4].weight = 4;

		graph.kruskalMST();
	}
}

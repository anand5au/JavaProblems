package problems;

import java.util.*;
import java.util.LinkedList;;

class FNode
{

	public String data;
	public FNode left = null;
	public FNode right = null;

	public FNode(String d)
	{
		data = d;
	}
}

public class Main
{
	FNode root;
	
	public Main()
	{
		root = null;
	}
	
	public FNode find(FNode root, String d)
	{
		if (root == null)
			return null;

		if (root.data.equals(d))
			return root;

		FNode temp;
		
		temp = find(root.left,d);
		if(temp != null)
			return temp;
		temp = find(root.right,d);
		return temp;
	}
	
	public FNode insert(FNode root, String parent, String d)
	{
		FNode newNode = new FNode(d);
		if(root == null)
		{
			FNode newParent = new FNode(parent);
			root = newParent;
			root.left = newNode;
			return root;
		}
		
		FNode temp = find(root, parent);
			
		if(temp.left == null)
			temp.left = newNode;
		else
			temp.right = newNode;
		
		return root;
	}
	
	public void BFS(FNode root, String d)
	{
		if(root == null) return;
		
		Queue<FNode> q = new LinkedList<FNode>();
		Set<String> level = new TreeSet<String>();
		int currLevel = 0, nextLevel = 0;
		FNode temp = root;
		
		q.offer(temp);
		currLevel++;
		level.add(temp.data);
		
		if(level.contains(d))
		{
			printSiblings(level);
			return;
		}
		
		level.clear();
		while(!q.isEmpty())
		{
			temp = q.poll();
			currLevel--;
			if(temp.left != null)
			{
				q.offer(temp.left);
				nextLevel++;
				level.add(temp.left.data);
			}
			if(temp.right != null)
			{
				q.offer(temp.right);
				nextLevel++;
				level.add(temp.right.data);
			}
			if(currLevel == 0)
			{
				currLevel = nextLevel;
				nextLevel = 0;
				if(level.contains(d))
				{
					printSiblings(level);
					return;
				}
				level.clear();
			}
		}
	}
	
	public void printSiblings(Set<String> set)
	{
		StringBuilder sb = new StringBuilder();
		for(String a : set)
			sb.append(a + ",");
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Main tree = new Main();
		String s = "";
		while(sc.hasNext())
		{
			s = sc.nextLine();
			System.out.println(s);
			String[] s1 = s.split(",");
			String person = s1[s1.length-1];
			for(int i=0;i<s1.length-1;i++)
			{
				String parent = s1[i].split("->")[0];
				String child = s1[i].split("->")[1];
				tree.root = tree.insert(tree.root, parent, child);
			}
			tree.BFS(tree.root,person);
		}
		sc.close();
	}
}

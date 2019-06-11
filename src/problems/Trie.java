package problems;

class TrieNode
{
	TrieNode[] children;
	boolean isLeaf;

	public TrieNode()
	{
		this.children = new TrieNode[256];
	}

	public void printChildren()
	{
		for (char i = 0; i < 256; i++)
		{
			if (children[i] == null)
				continue;
			if (children[i].isLeaf)
				System.out.println(i);
			else
				System.out.print(i);
			children[i].printChildren();
		}
	}

	public void printChildren(String prefix)
	{
		for (char i = 0; i < 256; i++)
		{
			if (children[i] == null)
				continue;
			System.out.print(prefix);
			children[i].printChildren();
		}
	}
}

public class Trie
{
	private TrieNode root;

	public Trie()
	{
		this.root = new TrieNode();
	}

	public TrieNode getRoot()
	{
		return this.root;
	}

	public void printChildren()
	{
		TrieNode t = getRoot();
		for (char i = 0; i < 256; i++)
		{
			if (t.children[i] == null)
				continue;
			System.out.print(i);
			t.children[i].printChildren();
			System.out.println();
		}
	}

	// Inserts a word into the trie.
	public void insert(String word)
	{
		TrieNode t = getRoot();
		for (int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			if (t.children[c] == null)
				t.children[c] = new TrieNode();
			t = t.children[c];
		}
		t.isLeaf = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word)
	{
		TrieNode t = searchNode(word);

		if (t != null)
			return t.isLeaf;
		else
			return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix)
	{
		if (searchNode(prefix) == null)
			return false;
		else
			return true;
	}

	public void autoComplete(String s)
	{
		TrieNode t = searchNode(s);
		if (t.isLeaf)
			System.out.println(s);
		t.printChildren(s);
	}

	public TrieNode searchNode(String str)
	{
		TrieNode t = getRoot();
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (t.children[c] != null)
				t = t.children[c];
			else
				return null;
		}
		return t;
	}

	public static void main(String args[])
	{
		Trie t = new Trie();
		t.insert("cat");
		t.insert("cater");
		t.insert("base");
		t.insert("basement");
		t.insert("baseline");
		t.printChildren();
		// System.out.println(t.search("cat"));
		// System.out.println(t.search("cate"));
		t.autoComplete("cat");
	}
}

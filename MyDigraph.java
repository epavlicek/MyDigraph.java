package algs42;

import stdlib.*;
import algs13.Bag;
import algs13.Queue;
import java.util.HashSet;

// See instructions below
public class MyDigraph {

	/////////////////////////////////////////////////////////////////////////
	// Do not modify anything in this section
	// This is a representation of a graph using Node objects, rather than ints.
	// To build the graph, we use an array of Node objects.
	/////////////////////////////////////////////////////////////////////////
	static class Node {
		private String key;
		private Bag<Node> adj;
		public Node (String key) {
			this.key = key;
			this.adj = new Bag<> ();
		}
		public String toString () { return key; }
		public void addEdgeTo (Node n) { adj.add (n); }
		public Bag<Node> adj () { return adj; }
	}
	
	Node[] node;
	int V;
	int E;
	public static boolean DEBUG = false;
	
	public MyDigraph (int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		this.node = new Node[V];
		for (int i=0; i<V; i++)  {
			node[i] = new Node ("n" + (DEBUG ? i : StdRandom.uniform (100)));
		}
	}
	
	public MyDigraph(Digraph G) {
		this (G.V ()); // run the first constructor
		for (int v=0; v<V; v++)  {
			for (int w : G.adj (v))
				addEdge(v, w);
		}
	}
	
	public MyDigraph(In in) {
		this (in.readInt()); // run the first constructor
		int E = in.readInt();
		if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	
	public void addEdge(int v, int w) {
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
		if (w < 0 || w >= V) throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (V-1));
		node[v].addEdgeTo (node[w]);
		E++;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(String.format("%s: ", node[v]));
			for (Node w : node[v].adj ()) {
				s.append(String.format("%s ", w));
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	
	public void toGraphviz(String filename) {
		GraphvizBuilder gb = new GraphvizBuilder ();
		for (int v = 0; v < V; v++) {
			gb.addNode (node[v]);
			for (Node n : node[v].adj ())
				gb.addEdge (node[v], n);
		}
		gb.toFile (filename);
	}

	/////////////////////////////////////////////////////////////////////////
	// You may modify anything below this.
	/////////////////////////////////////////////////////////////////////////
	// Your goal is to complete the methods below.
	// All of these methods may take time order V+E (where E is the number of edges)
	// You should not need to add any new fields.
	// You can define new functions.
	

	// mark returns an array of booleans: returnValue[i] should be true iff node[i] is
	// reachable from node[s] by following the pointers in the adjacency list.
	public boolean[] mark (int s) {
		// TODO
		return null;
	}

	// isTree returns true if the object graph rooted at node[s] is a (rooted out) tree  
	// (e.g. No duplicate paths or cycles)
	public boolean isTree (int s) {
		// TODO
		return false;
	}

	// hasCycle returns true if there is a cycle reachable from node[s].
	// hint: track the path through each node and adjacent nodes.
	public boolean hasCycle (int s) {
		// TODO
		return false;
	}


	// Here are my results on three files from the data directory:
	//
	// tinyDG.txt
	// marked( 0): [1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]
	// marked( 1): [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	// marked( 2): [1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]
	// marked( 3): [1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]
	// marked( 4): [1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]
	// marked( 5): [1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]
	// marked( 6): [1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1]
	// marked( 7): [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
	// marked( 8): [1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1]
	// marked( 9): [1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1]
	// marked(10): [1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1]
	// marked(11): [1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1]
	// marked(12): [1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1]
	// isTree:     [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	// hasCycle:   [1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
	//
	// tinyDGex2.txt
	// marked( 0): [1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]
	// marked( 1): [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	// marked( 2): [1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]
	// marked( 3): [1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]
	// marked( 4): [0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0]
	// marked( 5): [1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]
	// marked( 6): [1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]
	// marked( 7): [0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1]
	// marked( 8): [0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0]
	// marked( 9): [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
	// marked(10): [1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]
	// marked(11): [0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1]
	// isTree:     [0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0]
	// hasCycle:   [1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]
	//
	// tinyDAG.txt
	// marked( 0): [1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1]
	// marked( 1): [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	// marked( 2): [1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1]
	// marked( 3): [0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]
	// marked( 4): [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0]
	// marked( 5): [0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0]
	// marked( 6): [0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1]
	// marked( 7): [0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1]
	// marked( 8): [0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1]
	// marked( 9): [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1]
	// marked(10): [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
	// marked(11): [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1]
	// marked(12): [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
	// isTree:     [0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1]
	// hasCycle:   [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

	
	private static class Test {
		String name;
		MyDigraph y;
		public Test (String name, String filename) {
			this.name = name;
			this.y = new MyDigraph (new In (filename));
		}
		public Test (String name, Digraph G) {
			this.name = name;
			this.y = new MyDigraph (G);
		}
	}
	
	public static String booleanArraytoString (boolean[] a) {
		StringBuilder sb = new StringBuilder ();
		sb.append ("[");
		boolean comma = false;
		if ( a != null ) {
			for (boolean b : a) {
				if (comma) { sb.append (", "); } else { comma = true; }
				sb.append (b ? '1' : '0');
			}
		}
		sb.append ("]");
		return sb.toString ();
	}	
	
	public static void main (String[] args) {
		StdRandom.setSeed (0);
		MyDigraph.DEBUG = false;
		
		Test t = new Test("tinyDGex2", "data/tinyDGex2.txt");
		MyDigraph Y = t.y;
		StdOut.println (t.name);
		Y.toGraphviz (t.name + ".png");
		boolean[][] marked = new boolean[Y.V][];
		boolean[] isTree = new boolean[Y.V];
		boolean[] hasCycle = new boolean[Y.V];
		for (int v=0; v<Y.V; v++) {
			marked[v] = Y.mark (v);
			isTree[v] = Y.isTree (v);
			hasCycle[v] = Y.hasCycle (v);
		}
			
		String[] expected_result = 
		{
			"[1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]",
			"[0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
			"[1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]",
			"[1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]",
			"[0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0]",
			"[1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]",
			"[1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]",
			"[0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1]",
			"[0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0]",
			"[0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]",
			"[1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]",
			"[0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1]",
			"[0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0]", // isTree
			"[1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]"	// hasCycle
		};
		
		int v = 0;
		for (v=0; v<Y.V; v++) 
		{
			if ( v > 0 ) StdOut.format(", ");
			StdOut.format ("%s(%d)", Y.node[v].key, v );
		}
		
		StdOut.println ();
		StdOut.println ();

		for (v=0; v<Y.V; v++) 
		{
			String result = booleanArraytoString (marked[v]);
			String validate = result.equals(expected_result[v]) ? "Correct" : "ERROR: Expecting " + expected_result[v];
			StdOut.format ("marked(%2d): %s  - %s\n", v, result, validate );
		}
		
		String istree_result = booleanArraytoString (isTree);
		String istree_validate = istree_result.equals(expected_result[v]) ? "Correct" : "ERROR: Expecting " + expected_result[v];
		StdOut.format ("isTree:     %s  - %s\n", istree_result, istree_validate);

		String hascycle_result = booleanArraytoString (hasCycle);
		String hascycle_validate = hascycle_result.equals(expected_result[++v]) ? "Correct" : "ERROR: Expecting " + expected_result[v];
		StdOut.format ("hasCycle:   %s  - %s\n", hascycle_result, hascycle_validate);
		
		StdOut.println ();
		
	}
}

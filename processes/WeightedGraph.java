package processes;

import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

public class WeightedGraph {
	public static final int DefaultSize = 20;
	public static SLinkedList<Edge>[] edges; 

	/** post: initialise graph of default size (number of vertices) */
	public WeightedGraph() {
		this(DefaultSize);
	}

	/**
	 * post: initialise graph of indicated size display error message if size is
	 * invalid
	 */
	@SuppressWarnings("unchecked")
	public WeightedGraph(int size) {
		if (size > 0) {
			edges = (SLinkedList<Edge>[]) Array.newInstance(SLinkedList.class,
					size);
			for (int i = 0; i < size; i++) {
				edges[i] = new SLinkedList<Edge>();
			}
		} else {
			System.out.println("Error: invalid number of vertices.");
		}
	}

	/**
	 * post: add edge from vertex #v1 to #v2 with the specified weight if both
	 * vertex numbers are valid
	 */
	public void addEdge(int v1, int v2, int weight) {
		if (v1 == v2) {
			System.out.println("Error: self loops not allowed.");
		} else if (v1 < 0 || v2 < 0 || v1 >= edges.length || v2 >= edges.length) {
			System.out.println("Error: invalid vertex.");
		} else if (hasEdge(v1, v2)) {
			System.out.println("Error: edge already exists.");
		} else {
			edges[v1].addLast(new Edge(v1, v2, weight));
			edges[v2].addLast(new Edge(v2, v1, weight));
		}
	}

	/** @return true iff v1 and v2 are valid and adjacent */
	public boolean hasEdge(int v1, int v2) {
		return getWeight(v1, v2) != Integer.MAX_VALUE;
	}

	/**
	 * @return the weight of the edge from v1 to v2, or infinity if no such edge
	 *         exists
	 */
	public int getWeight(int v1, int v2) {
		if (v1 < 0 || v2 < 0 || v1 >= edges.length || v2 >= edges.length) {
			return Integer.MAX_VALUE;
		} else {
			Iterator<Edge> it = getIncidentEdges(v1);
			while (it.hasNext()) {
				Edge e = it.next();
				if (e.getVertex2() == v2) {
					return e.getWeight();
				}
			}
			return Integer.MAX_VALUE;
		}
	}

	/** @return an iterator over all edges incident on vertex # vNum */
	public Iterator<Edge> getIncidentEdges(int vNum) {
		if (vNum < 0 || vNum >= edges.length)
			return null;
		else
			return edges[vNum].iterator();
	}

	/** @return true if the sequence of vertices is a path in the graph */
	public boolean isAPath(int[] verts) {
		for (int i = 0; i < verts.length - 1; i++) {
			if (!hasEdge(verts[i], verts[i + 1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return the total weight of all edges in the path represented by the
	 *         array verts infinity if verts does not represent a path
	 */
	public int totalWeight(int[] verts) {
		int sum = 0;
		for (int i = 0; i < verts.length - 1; i++) {
			sum += getWeight(verts[i], verts[i + 1]);
		}
		return sum;
	}

	/**
	 * @return all information about the graph (edges and weights) in a human
	 *         readable form
	 */
	public String toString() {
		String res = "Edges:\n";
		Iterator<Edge> iter;
		Edge e;
		for (int i = 0; i < edges.length; i++) {
			iter = getIncidentEdges(i);
			while (iter.hasNext()) {
				e = iter.next();
				res += e;
			}
			res += "\n";
		}
		return res;
	}

	public int getSize() {
		return edges.length;
	}

	@SuppressWarnings("rawtypes")
	public SLinkedList[] getAdjList() {
		return edges;
	}

	/** post: read the representation of a weighted graph from a file */
	public static WeightedGraph readGraph(String file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		int size = Integer.parseInt(in.readLine());
		WeightedGraph wg = new WeightedGraph(size);
		if (size > 0) {
			int vNum;
			int vNum2;
			int weight;
			String sval = in.readLine();
			while (sval != null) {
				vNum = Integer.parseInt(sval);
				vNum2 = Integer.parseInt(in.readLine());
				weight = Integer.parseInt(in.readLine());
				wg.addEdge(vNum, vNum2, weight);
				sval = in.readLine();
			}
		}
		in.close();
		return wg;
	}

	public String dfs(int start) {
		Dfs d = new Dfs(this, start);
		return d.getDfs();

	}
	
	public String bfs(int start){
		Bfs b = new Bfs(this, start);
		
		return b.getBfs();
		
	}

}

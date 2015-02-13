package processes;

//author: Tim Wahls
//date: 8/27/2004
//purpose: implement edges of a weighted graph
public class Edge implements Comparable<Object> {
	private final int v1;
	private final int v2;
	private final int weight;

	public Edge() {
		weight = 0;
		v1 = 0;
		v2 = 0;
	}

	public Edge(int v1, int v2, int wt) {
		this.v1 = v1;
		this.v2 = v2;
		weight = wt;
	}

	public int getVertex1() {
		return v1;
	}

	public int getVertex2() {
		return v2;
	}

	public int getWeight() {
		return weight;
	}

	public String toString() {
		return "from: " + v1 + " to: " + v2 + " weight: " + weight + "\n";
	}

	public int compareTo(Object o) {
		if (weight < ((Edge) o).getWeight())
			return -1;
		else if (weight == ((Edge) o).getWeight())
			return 0;
		else
			return 1;
	}
}

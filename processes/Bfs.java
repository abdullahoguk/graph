package processes;

import java.util.Iterator;

public class Bfs {

	// public WeightedGraph g;
	NodeQueue<SLinkedList<Edge>> q;
	String result;
	Boolean[] visitStates;
	SLinkedList<Edge> currList;
	int currEdge;

	public Bfs(WeightedGraph graph, int start) {
		result = "";
		int size = graph.getSize();
		visitStates = new Boolean[size];

		for (int i = 0; i < size; i++) {
			visitStates[i] = false;
		}

		q = new NodeQueue<SLinkedList<Edge>>();
		q.enqueue(WeightedGraph.edges[start]);
		result = result + "" + start;
		visitStates[start] = true;

		while (!q.isEmpty()) {
			currList = q.dequeue();
			Iterator<Edge> it = currList.iterator();

			while (it.hasNext()) {
				Edge temp = it.next();
				currEdge = temp.getVertex2();

				if (!visitStates[currEdge]) {

					q.enqueue(WeightedGraph.edges[currEdge]);
					result = result + " " + currEdge;
					visitStates[currEdge] = true;
				}
			}
		}
	}

	public String getBfs() {
		return result;
	}
}

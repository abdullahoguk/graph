package processes;

import java.util.Iterator;

public class ShortestPath{

	Integer[] pathDistance;
	String[] sPaths;
	NodeQueue<Integer> q;
	int size;
	int curr;
	Edge currEdge;
	WeightedGraph g;


	@SuppressWarnings("unchecked")
	public ShortestPath(WeightedGraph g, int start){
		
		this.g = g;
		
		q = new NodeQueue<Integer> ();
		q.enqueue(start);
		size = g.getSize();

	   	pathDistance = new Integer[size];
	   	for (int i=0;i<size;i++){
	      	pathDistance[i]=Integer.MAX_VALUE;
	   	}
	   	pathDistance[start]=0;

	
	   	sPaths = new String[size];
	  	for (int i=0;i<size;i++){
	      	sPaths[i]=""+i;
	   	}

	   	while(!q.isEmpty()){
	   		curr = q.dequeue();
	   		SLinkedList<Edge> currList=g.getAdjList()[curr];
	   		Iterator<Edge> it = currList.iterator();
	   		while(it.hasNext()){
	   			currEdge=it.next();
	   			if((pathDistance[currEdge.getVertex2()] > ( pathDistance[currEdge.getVertex1()] + currEdge.getWeight()) ) )
	   			{
	   				pathDistance[currEdge.getVertex2()] = (pathDistance[currEdge.getVertex1()] + currEdge.getWeight());
	   				q.enqueue(currEdge.getVertex2());
	   			}
	   		}
	   	}
	}
	
	
	public String[] getPaths(){
		return sPaths;
	}
	
	public Integer[] getDistance(){
		return pathDistance;
	}
} 
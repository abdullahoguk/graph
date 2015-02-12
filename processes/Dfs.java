package processes;

import java.util.*;

public class Dfs {
	
	String result;
	Boolean[] visitStates;
	SLinkedList<Edge> currList;
   
    WeightedGraph graph;
	public Dfs(WeightedGraph g, int start){
		result = "";
		graph = g;
		int size= graph.getSize();

		visitStates = new Boolean[size];
    	for (int i=0;i<size;i++){
      	visitStates[i]=false;
    	}
		
		dfsEval(start);
	}
	
	@SuppressWarnings("unchecked")
	private void dfsEval(int v) {
		SLLStack<Integer> stack = new SLLStack<Integer>();
		result+=v+" ";
		stack.push(v);
		visitStates[v]=true;

		while(!stack.isEmpty()){
			if(visitStates[stack.top()]){
				int currEdge=stack.top();
				currList=graph.getAdjList()[currEdge];

				Iterator<Edge> it = graph.getAdjList()[currEdge].iterator();	
				while(it.hasNext()){
					int curr=it.next().getVertex2();
					if(!visitStates[curr]){
						dfsEval(curr);
					}
				}
			}
			else if(!visitStates[stack.top()]){
				continue;
			}
			stack.pop();
		}
	}
	
	public String getDfs(){
		return result;
	}

}

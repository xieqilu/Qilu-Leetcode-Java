import java.util.*;
/**
 * 
 * @author xieqilu
 * For the graph traversing algorithm
 */
public class Solution {
	
	/**
	 * A node in a graph
	 */
	private static class Node {
		private final Set<Node> neighbors;
		Node()
		{
			this.neighbors = new HashSet<>();
		}
	}
	
	private static Map<Integer, Integer> calculateDegreeCount(Node node) {
	      // YOUR CODE HERE
	        Queue<Node> bfsQ=new LinkedList<Node>();
	        HashSet<Node> visited=new HashSet<Node>();
	        HashMap<Integer,Integer> res=new HashMap<Integer,Integer>();
	        bfsQ.add(node);
	        visited.add(node);
	        while (!bfsQ.isEmpty()){
	            Node temp=bfsQ.remove();
	            int count=0;
	            for(Node neighbor:temp.neighbors){
	                count+=1;
	                if(!visited.contains(neighbor)){
	                    visited.add(neighbor);
	                    bfsQ.add(neighbor);
	                }
	            }
	            if (res.containsKey(count)){
	                int prevCount=res.get(count);
	                res.put(count,prevCount+1);
	            }else{
	                res.put(count,1);
	            }
	        }
	        return res;
	    }

}

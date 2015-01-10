//largest common subtrees
// package intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kurt
 */
public class Test {

    private static class Node {

        private final int id;
        private final List<Node> children;
        private String str;

        Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
            this.str = new String();
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }

    private static List<Node> getLargestCommonSubtrees(Node root) {
        List<Node> res = new ArrayList<Node>();
        if (root == null) {
            return res;
        }
        getStructure(root);
        findResult(res);
        return res;
    }
// get the result in hashmap, compare and get the largest
    private static Map<String, List<Node>> map = new HashMap<String, List<Node>>();
    
    private static String getStructure(Node root) {
        if (root == null) {
            return null;
        }
        if (root.children.size() == 0) {
            root.str += "0";
        } else if (root.children.size() > 0) {
            root.str += root.children.size();
        }
        for (Node n : root.children) {
            root.str += getStructure(n); //add string, not add int
        }
        //System.out.println(root.id + " "+root.str);
        if (!map.containsKey(root.str)) {
            ArrayList<Node> list = new ArrayList<Node>();
            list.add(root);
            map.put(root.str, list);
        } else {
            List<Node> tmp = map.get(root.str);
            tmp.add(root);
            map.put(root.str, tmp);
        }
        return root.str;
    }
    
    private static void findResult(List<Node> res) {
        String str = "";
        for (String s : map.keySet()) {
            //if (map.get(s).size() > 1 && s.length() > str.length()) {
        	if(map.get(s).size()>1 && getSubTreeSize(s) > getSubTreeSize(str)){
                str = s;
            }
        }
        for (Node n : map.get(str)) {
            res.add(n);
        }
    }
    
    private static int getSubTreeSize(String s){
    	int res = 0;
    	for(int i=0;i<s.length();i++){
    		char tmp = s.charAt(i);
    		res += Character.getNumericValue(tmp);
    	}
    	return res;
    }
    



    private static void basicTest() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        Node node16 = new Node(16);
        Node node17 = new Node(17);
        Node node18 = new Node(18);
        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);
        node3.children.add(node5);
        node3.children.add(node6);
        node5.children.add(node8);
        node8.children.add(node12);
        node8.children.add(node13);
        node12.children.add(node17);
        node6.children.add(node9);
        node9.children.add(node14);
        node9.children.add(node15);
        node15.children.add(node18);
        node4.children.add(node7);
        node7.children.add(node10);
        node7.children.add(node11);
        node11.children.add(node16);
//node.children.add(node);
        List<Node> result = getLargestCommonSubtrees(node1);
        for (Node node : result) {
            System.out.print(node.id + " ");
        }
//        if (!result.contains(node4)) {
//            throw new AssertionError(String.format("Expected to find node 1 but found nodes %s",
//                    result));
//        }
//        if (!result.contains(node6)) {
//            throw new AssertionError(String.format("Expected to find node 2 but found nodes %s",
//                    result));
//        }
    }

    public static void main(String[] args) {
        basicTest();
    }
}

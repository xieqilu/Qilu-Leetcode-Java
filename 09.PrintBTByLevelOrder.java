/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
  * java is always pass by value, even if we pass an object,
  * we actually pass the value of the object reference.
  * Which means if we change the object itself in the method,
  * the change is visible to the caller.
  * But if we let the reference point to another object,
  * the change is not visible to the caller.
  * 
  * In the following code:
  * when we want to add currentNodes to allNodes and then clear
  * currentNodes, if we directly add currentNodes to allNodes and then
  * call currentNodes.clear(). The list added to allNodes will be cleared.
  * Because by add currentNodes to allNodes, we actually add the reference
  * to allNodes. So use reference to clear the object will change the object
  * in allNodes.
  * To avoid this problem, we need copy elements of currentNodes to a temp list
  * and then add the temp list to allNodes.
  * 
  * In C#, when passing object, default situation is the same as in Java. That is,
  * we actually pass the value of the object reference. If we use ref or out when passing
  * object, then we actually pass the reference of object reference. Then if we let
  * the reference point to another object, the change is visible to the caller.
  * */
  
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        List<Integer> currentNodes = new ArrayList<Integer>();
        List<List<Integer>> allNodes = new ArrayList<List<Integer>>();
        if(root==null) return allNodes;
        currentLevel.add(root);
        while(currentLevel.size()!=0){
            TreeNode currNode = currentLevel.remove();
            if(currNode!=null){
                currentNodes.add(currNode.val);
                nextLevel.add(currNode.left);
                nextLevel.add(currNode.right);
            }
            if(currentLevel.size()==0){
                while(nextLevel.size()!=0){
                    currentLevel.add(nextLevel.remove());
                }
                //cannot directly add currentNodes to allNodes
                //see above explanation
                List<Integer> temp = new ArrayList<Integer>();
                for(int i : currentNodes)
                    temp.add(i);
                allNodes.add(temp);
                currentNodes.clear();
            }
        }
        allNodes.remove(allNodes.size()-1);
        return allNodes;
    }
}

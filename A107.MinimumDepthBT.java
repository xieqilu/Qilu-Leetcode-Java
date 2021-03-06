/**
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

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
  * Solution1:
  * Use Recursive DFS to solve this problem.
  * Note the minimum depth must end at a leaf node, means a node has not child
  * If a node has only one child, we must continum search for the child.
  * 
  * So if both children of root are not null, we keep search minimum of return value
  * of the two children.
  * If one child of the root is not null and the other is null, we keep search the node
  * that is not null
  * If both children are null, we return 1.
  * 
  * To achieve the above, when at least one child is null, we keep search maximum of return value
  * 
  * Solution2:
  * Iterative BFS can also be used to solve this problem.
  * The key point is to break the while loop when we find the first node that has no children.
  * Then this node must be the highest node with no children, then the level to this node should
  * be the minimum Depth we want.
  * */
  
public class Solution {
    public int minDepth(TreeNode root) { //Recursive DFS
        if(root==null) return 0;
        if(root.left==null ||root.right==null){
            //root.left==null&&root.right==null,return 1+0
            //root.left==null&&root.right!=null,return 1+minDepth(root.left)
            //root.right!=null&&root.right==null,return 1+minDepth(root.right)
            return 1+Math.max(minDepth(root.left),minDepth(root.right));
        }
        //root.left!=null&&root.right!=null
        return 1+ Math.min(minDepth(root.left),minDepth(root.right));
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        Queue<TreeNode> q2 = new LinkedList();
        int level = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) q2.add(node.left);
            if (node.right != null) q2.add(node.right);
            if (node.left == null && node.right == null) break;
            if (q.isEmpty()) {
                level++;
                q = q2;
                q2 = new LinkedList();
            }
        }
        return level;
    }
}

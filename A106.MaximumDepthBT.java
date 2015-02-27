/**
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
  * This is an classic recursive question,
  * maxDepth(root) = Math.max(maxDepth(root.left)+1, 
  *                         maxDepth(root.right)+1)
  * Base case: when root==null, return 0;
  * 
  * Solution2:
  * We can also use Iterative BFS to solve this problem.
  * The max Depth of a BT is actually the number of level the BT has.
  * So use a queue to do classic iterative BFS, when finish a level
  * we increment the int level. After the BFS, return level
  * */
 
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int rightDepth = maxDepth(root.left);
        int leftDepth = maxDepth(root.right);
        return Math.max(rightDepth+1,leftDepth+1);
    }
}

public class Solution2 {
// BFS
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQ = new LinkedList<TreeNode>();
        if (root == null) return 0;
        int level = 0;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) nextQ.add(node.left);
            if (node.right != null) nextQ.add(node.right);
            if (q.isEmpty()) {
                level++;
                q = nextQ; 
                //Note: cannot clear nextQ, now nextQ and q point to a same LinkedList
                //we need to assign a new LinkedList to nextQ.
                nextQ = new LinkedList<TreeNode>();
            }
        }
        return level;
    }
}

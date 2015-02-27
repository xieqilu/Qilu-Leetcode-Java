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
  * */
 
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int rightDepth = maxDepth(root.left);
        int leftDepth = maxDepth(root.right);
        return Math.max(rightDepth+1,leftDepth+1);
    }
}

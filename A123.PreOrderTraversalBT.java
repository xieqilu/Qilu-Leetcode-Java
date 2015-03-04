/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?


Solution:
This is a very general and important problem. PreOrder traversal is a kind of DFS, to 
do DFS iteratively, we must use a stack. (To do BFS iteratively, we must use a queue)
Remeber the three kinds of DFS tree traversal:
PreOrder: root->left->right
InOrder: left->root->right
PostOrder: left->right->root
Note left is always ahead of right, the difference of pre/in/post is the position of root.

Also pay attention of the sequence we put children of root to the stack. Since left child
shold be pop ahead of right child, and stack is first in last out, so we need to first put
right child into the stack then left child.
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
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode current = stack.pop();
            result.add(current.val);
            if(current.right!=null)
                stack.push(current.right);
            if(current.left!=null)
                stack.push(current.left);
        }
        return result;
    }
}

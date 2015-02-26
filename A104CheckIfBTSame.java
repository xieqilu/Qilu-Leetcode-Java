/**
 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Solution:
Use Pre-Order Traversal to compare if two tress are the same. 
Do not use In-Order Traversal because two different trees may produce
the same node list by In-order Traversal.

Note: We do not need to use two Lists to store all the nodes of two BT, because 
we are not required to seariliaze the two BT. we can just compare node in the steps
of Pre-Order traversal.
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
 
 //My accepted solution
 public class Solution { 
    private void inOrder(TreeNode root, List<TreeNode> list){
        if(root==null) {
            list.add(null);
            return;
        }
        list.add(root);
        inOrder(root.left, list);
        inOrder(root.right,list);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        inOrder(p, list1);
        inOrder(q, list2);
        if(list1.size()==0 && list2.size()==0) return true;
        if(list1.size()!=list2.size()) return false;
        for(int i=0;i<list1.size();i++){
            TreeNode m = list1.get(i);
            TreeNode n = list2.get(i);
            if((m!=null&&n==null)||(m==null&&n!=null))
                return false;
            else if((m!=null&&n!=null)&&m.val!=n.val)
                return false;
        }
        return true;
    }
}

//Leetcode Official Solution: Much simpler and better looking than mine
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}

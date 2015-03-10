/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * 
 * Special Note: got this problem in a phone interview, but failed to find the correct
 * base case for the recursive call. A very stupid confusion and mistake, shows I do not
 * understand recrusion completely. So this problem is an important reminder that reminds
 * me to studay harder, remember god has a bigger plan, better than mine.
 * 
 * 
 * Solution:
 * The recursive logic is very simple, pick the middle element of the array, use it as the 
 * root, then recursivly pick the middle of left part and the middle of right part to construct
 * the binary tree.
 * 
 * Pay attention to the base case for the recurisve call. When should the recursive call return?
 * How to avoid Stack Overflow? The base case is when start>end we need to return null. Notice that
 * for each recursive call, we need to get the middle element as num[(start+end)/2]. As long as start
 * is not greater than end, we can continue finding new node for the binary tree. If start is equal 
 * to end, then there is still an element to visit in the part of the array.
 * 
 * The base case is very similiar to a binary search, we need an array, an int start and an int end to 
 * perform the binary search. And for each recursive call, we pick a half of the array to continue. So
 * when start>end, that means the search should be over.
 * 
 * Just remember!!!!! THE BASE CASE IS START>END, RETURN NULL!!!!
 * */


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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0) return null;
        return convertHelper(num, 0, num.length-1);
    }
    
    private TreeNode convertHelper(int[] num, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = convertHelper(num, start, mid-1);
        root.right = convertHelper(num, mid+1, end);
        return root;
    }
}

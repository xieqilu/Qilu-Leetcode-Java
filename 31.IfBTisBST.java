public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        //Do not use Interger.MIN_VALUE and Integer.MAX_VALUE as initial values
        //instead, use two null Integer object
        return valid(root, null, null); 
    }
    
    private boolean isValidBSTHelper(TreeNode p, Integer low, Integer high) { //use Integer object instead of int 
        if (p == null) return true;
        //we can directly compare Integer object with int type
        return (low == null || p.val > low) && (high == null || p.val < high)
            && isValidBSTHelper(p.left, low, p.val)
            && isValidBSTHelper(p.right, p.val, high);
    }
}

public class Solution2 {
    private Integer prev;//java cannot pass by reference, so must use a global variable
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isValidBSTHelper(root);
    }
    
    private boolean isValidBSTHelper(TreeNode p) {
        if (p == null) return true;
        if (isValidBSTHelper(p.left)) {
            if(prev==null||p.val>prev){
                prev = p.val;
                return isValidBSTHelper(p.right);
            }
            return false;
        }
        return false;
    }
}

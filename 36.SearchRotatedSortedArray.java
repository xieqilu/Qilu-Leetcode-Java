/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] A, int target) {
        int length = A.length;
        int L = 0, R = length-1;
        while (L < R) {
            int M = (L+R)/2;
            if (A[L] <= A[M]) { //left sub is sorted
                if (A[L] <= target && target <= A[M]) { //in left sub
                    R = M;
                } else { //in right sub
                    L = M+1;
                }
            } else { //right sub is sorted
                if (A[M] <= target && target <= A[R]) { //in right sub
                    L = M;
                } else {  //in left sub
                    R = M-1;
                }
            }
        }
        if (A[L] == target) return L;
        return -1; //target is not in array
    }
}

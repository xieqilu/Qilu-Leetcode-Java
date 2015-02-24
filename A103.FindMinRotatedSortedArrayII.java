/**
 * ollow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Solution:
For case where AL == AM == AR, the minimum could be on AM’s left or right side
(eg, [1, 1, 1, 0, 1] or [1, 0, 1, 1, 1]). 
In this case, we could not discard either subarrays
and therefore such worst case degenerates to the order of O(n).
*/

public class Solution {
    public int findMin(int[] num) {
        if(num.length == 0)
            return -1;
        int L=0, R=num.length-1;
        while(L<R){
            int M = (L+R)/2;
            if(num[M]>num[R]) //min must be at right sub
                L = M+1;
            else if(num[M] < num[L])
                R=M;
            else if(num[L]==num[M] && num[R]==num[M])
                L=L+1;
            else
                R=L;
        }
        return num[L];
    }
}

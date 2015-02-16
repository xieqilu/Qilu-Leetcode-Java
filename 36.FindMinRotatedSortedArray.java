/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Solution: use a modified binary search
Each time compare the rightmost element with middle element
if num[right] < num[middle], then minmum must be at right sub
otherwise, minmum  must be at the left sub
*/

public class Solution {
    public int findMin(int[] num) {
        if(num.length == 0)
            return -1;
        int length = num.length;
        int left =0;
        int right = length-1;
        while(left<right){
            int middle = (left+right)/2;
            //cannot compare num[left] with num[middle], if only two elements
            //middle will be equal to left, so must use right element to compare
            //with middle element
            if(num[right]<num[middle]) //minmum must be at the right sub
                left = middle+1;
            else         //minmum must be at the left sub
                right = middle;
        }
        return num[left];
    }
}

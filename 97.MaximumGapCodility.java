/**
 * Given an array A, find max(min(abs(x-A[i]))) such that max(A[i])>=x<=min(A[i])
 * 
 * Given an array A, we can choose x in the range of max(A[i]) to min(A[i]),
 * for each x, there is a minimum value of abs(x-A[i]) we called xMin
 * Then we need to find and return the maximum value of xMin.
 * 
 * Example:
 * A:{1,2,4} output: 1
 * x is in the range of [1,4]. So x can be 1,2,3,4
 * x = 1 |1-1| = 0, |1-2| = 1, |1-4| = 3, min is 0
   x = 2 |2-1| = 1, |2-2| = 0, |2-4| = 2, min is 0
   x = 3 |3-1| = 2, |3-2| = 1, |3-4| = 1, min is 1
   x = 4 |4-1| = 3, |4-2| = 2, |4-4| = 0, min is 0
 *
 * So the maximum value is when x=3, min =1. Then we return 1;

 * These problem is very similiar to Maximum Gap on LeetCode. The only difference is that 
 * we need to return gap/2 instead of gap.
 * 
 * We can use the same approach (modified bucket sort).
 * 
 * Time complexity: O(n), Space complexity: O(n)

*/

public class Solution {
    public int maximumGap(int[] num) {
        if(num.length <2) //handle edge case
            return 0;
            
        int max = num[0]; //get min and max element of num
        int min = num[0];
        for(int k : num){
            if(k<min)
                min=k;
            if(k>max)
                max=k;
        }
        //get length and number of buckets
        int bucketLen = (int)Math.ceil((double)(max-min)/(double)(num.length-1));
        int bucketNum = (max-min)/bucketLen +1;
        //create list of buckets and fill all buckest with initial value -1
        List<int[]> buckets = new ArrayList<int[]>(bucketNum);
        for(int i=0;i<bucketNum;i++){
            buckets.add(new int[]{-1,-1});
        }
        //traverse num and use each element to update related bucket
        for(int k : num){
            int i = (k-min)/bucketLen; //get the No. of bucket
            if(buckets.get(i)[0] == -1 && buckets.get(i)[1] == -1){ //if bucket is empty
                buckets.get(i)[0] = k; //set local min to k
                buckets.get(i)[1] = k; //set local max to k
            }
            else{
                if(k<buckets.get(i)[0])
                    buckets.get(i)[0] = k;
                if(k>buckets.get(i)[1])
                    buckets.get(i)[1] = k;
            }
        }
        
        int gap = 0;
        int prev = 0;
        for(int i=1;i<bucketNum;i++){ //traverse all buckets to find gap
            if(buckets.get(i)[0]!=-1){ //if bucket is not empty
                int currGap = buckets.get(i)[0]-buckets.get(prev)[1];
                if(currGap > gap)
                    gap = currGap;
                prev = i;
            }
        }
        
        return gap/2;
    }
}

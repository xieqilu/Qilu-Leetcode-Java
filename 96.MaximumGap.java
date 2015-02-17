/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Example:
Array: {1,2,4} output: 4-2=2;
Array: {9,5,0,3,1} output: 9-5=4;

Solution:
If we use QuickSort to sort the given array and then find max gap between any two concecutive element,
the time complexity would be O(nlogn), n is the size of array. It's not a linear time solution.

Linear time solution:
Use modified bucket sort as follows:

Suppose there are N elements and they range from A to B.
Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]
Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], 
then we will have at most num = (B - A) / len + 1 of bucket

for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len 
and therefore maintain the maximum and minimum elements in each bucket.

Since the maximum difference between elements in the same buckets will be at most len - 1, 
so the final answer will not be taken from two elements in the same buckets.

For each non-empty buckets p, find the next non-empty buckets q, 
then q.min - p.max could be the potential answer to the question. 
Return the maximum of all those values.

Time: O(n) space: O(n)

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
        
        return gap;
    }
}

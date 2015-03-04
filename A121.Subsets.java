/**
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

/**
This is a very classic recursive and backtracking problem and worth to remember forever!

Solution 1: Recursive solution
The key point to solve this problem is to find the relationship bewtween subsets of n-1 elements
and subsets of n elements. If we already got all subsets of the first n-1 elements of the input array,
to get subsets of the first n elements, we just need to add the nth element to all subsets of first n-1
elements and then we have all new subsets for the nth element. Then we combine the new subsets and the 
subsets of first n-1 elements to get all subsets of first n elements.
Base case: when the array is empty, we just return a new list that contains only an empty list<int>.

The recursive method takes two inputs: the array and an int l indicating recursive level.
l=0 means an empty array. So in each recursive call, we are dealing with the (l-1)th element in the array.
So initially, we put the length of array into the recursive method.

Note for this specific problem, elements in a subsets must be in non-descending order. So we need to sort
the input array first, then do the above process. Also we need to do backtracking for the array which means
we need to first deal with empty array, array[0], array[1]...and so on. To make sure we do it in ascending order
so that the result subsets would be in non-descending order.


Solution2: Iterative solution
We can make a slightly otimization by turning the above recursive solution into iterative. But the idea is 
totally the same.


Solution3: Bit Manipulation/Binary representation
Although the above recursive solution is very classic and achieve the best time
complexity for this problem and probably more general for other problems. There is
another excellent solution for this problem using bit manipulation, which compeltely
reveal the beauty of Computer Science.

Recall that when we are generating a set, we have two choices for each element: 
1, the element is in the set (the "yes" state)
2, the element is not in the set (the "no" state)
This means that each subset is actually a sequence of yeses/nos like:
"yes,yes,no,yes,no,no" 

This gives us 2^n possible subsets (that's why the best time complexity is O(2^n)).
And our task becomes iterating all possible sequences of yes/no state. How could 
we do this efficiently? If each "yes" can be treated as 1 and each "no" can be
treated as 0, then each subset can be represented as a binary string. And the 
sequence of 1 and 0 is actually a binary number, which is integer. Then for an array
with n elements, each integer between 0 to 2^n will uniquely related to a subset
of the array!

So we can just iterate through all numbers from 1 to 2^n and translate the binary
representation of the numbers into a subset. Easy work!!!

Note: for the above two approaches, the time complexity will always be O(2^n), which
is the best we can do for this problem. Because an array containing n elements will 
have exactly 2^n subsets and we need to put all of them into the result list.

*/

//Java version of Solution3, solution1&2 refer c# version
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        int maxBinary = 1<<S.length; //get the number 2^n by shifting 1 to left for n times
        for(int i=0;i<maxBinary;i++){
            List<Integer> currSubset = convertIntToSet(i, S);
            subsets.add(currSubset);
        }
        return subsets;
    }
    
    private List<Integer> convertIntToSet(int i, int[] S){
        List<Integer> currSubset = new ArrayList<Integer>();
        int index=0;
        for(int j=i;j>0;j>>=1){ //each time shift j to right by 1 digit
            if((j&1)==1)
                currSubset.add(S[index]);
            index++;
        }
        return currSubset;
    }
}

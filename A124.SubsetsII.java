/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


Solution:
The only difference between this problem and the original subsets problem is the input array might
contains duplicate elements. But the output List<List<Integer>> should not contain any duplicate 
element (no duplicate List<Integer>).

So we can apply the same idea as the original subsets. First use a solution from the original subsets
to get all subsets with possible duplicate items. Then use a Hashset and traverse the subsets List and 
remove duplicate subset. Note if the current subset is already in the Hashset, after removing it, we need
to decrement i (i--). Because each time we remove an item from a List, the index of the List will be reordered.

Special Note:
The above solution works well for Java, because in Java HashSet.contains() compare the List object instead of 
the reference. So if two List<Integer> have the same content, they will be treated as same by this method.

But in C#, the above solution does not work. Because in C# HashSet.contains() compare the reference of the List
objects. So if two List are different objects, even if they have the same content, they will be treated as different.
*/


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        int maxBinary = 1<<S.length; //get the number 2^n by shifting 1 to left for n times
        for(int i=0;i<maxBinary;i++){
            List<Integer> currSubset = convertIntToSet(i, S);
            subsets.add(currSubset);
        }
        //remove duplicate items from subsets
        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        for(int i=0;i<subsets.size();i++){
            if(hs.contains(subsets.get(i))){
                subsets.remove(i);
                i--; //Do not forget this! if we remove an item from subsets, the index is reordered!
            }
            else
                hs.add(subsets.get(i));
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

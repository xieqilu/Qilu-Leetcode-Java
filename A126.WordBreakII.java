/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].


Solution:
This is a very hard problem about Dynamic Programming and Memorized Recursive DFS.
We can solve this problem using Memorized Recursive DFS.

Recursive DFS Process:
Suppose we split the input string into two parts: input.Substring(0,i) and input.Substring(i,len).
If we already get all match strings for input.Substring(i,len) and input.Substring(0,i) is also
in the dict. We can simply add input.Substring(0,i) to all match strings of input.Substring(i,len)
to get all match strings for the whole input string.

Base case: if input.Substring(i,len) is an empty string(""), we simply return a List of match 
stirngs containing only an empty string.

We can start from the first char of input string. Use a pinter i to get each substring
of input (input.Substring(0,i)), and compare each substring with the word in dict. If
a substring exists in the dict, we use the recursive method to find all matche strings 
for the rest substring (input.Substring(i,len)). Then for each match string for 
input.Substring(i,len), add the input.Substring(0,i) to it and then we get all match
strings for the whole input string.

Using the above method, for each input.Substring(0,i) that exists in dict, we keep calling 
the recursive method until we reach the end of input string to get a match string (sentence)
for the whole input string. After iterating through all input.Substring(0,i) that exists in dict,
we can get all match strings for the whole input string. So it's actually a DFS process in which
we keep moving forward on one path until reaching the end.

Memorized HashMap:
Note the above Recursive DFS process is not very efficient because we will do a lot of duplicate 
calling. So we need to store the intermediate results so that for each unique string (a part of input string),
we will only try to find all its match sentences for once.
We can use a HashMap (or a 2D array) to store these intermediate results. The key is a unique string,
and the value is a List of match sentences that related to this unique string. So in the recursive method,
if we find input string is already in the HashMap, we directly return the related vaule and won't do the 
duplicate recursive call.

Example: input string: "catcatcatcat" dict: {"cat","catcat"}
Using the above process, after finding "cat" is in the dict, we will call DFS("catcatcat") -> DFS("catcat");
And after finding "catcat" is in the dict, we will call DFS("catcat"). So if without using memorized HashMap,
we will call DFS("catcat") twice. But if we use memorized HashMap, we can make sure that DFS("catcat") will
only be called once.


Time Complexity: O(n^2)  n is the length of input string (input dict is a HashSet so find if a word exist in dict
will only take O(1) time. If input dict is an array, Time complexity is O(n^2*m)).
In the worst case, the number of entries in HashMap will be n^2/2.
This problem is very similiar to the Chess Phone Number problem, which can also be sovled by using Memorized 
Recursive DFS. The approach is almost the same.
*/


public class Solution {
    public ArrayList<String> wordBreak(String input, Set<String> dict) {
        Map<String, ArrayList<String>> memoized= new HashMap<String, ArrayList<String>>();
        return wordBreakDfs(input, dict,memoized);
    }
    
    public ArrayList<String> wordBreakDfs(String input, Set<String> dict, Map<String, ArrayList<String>> memoized) {
      ArrayList<String> ans = new ArrayList<String>();
      if (input.equals("")) {
          ans.add("");
          return ans;
      }
      if (memoized.containsKey(input)) {
          return memoized.get(input);
      }
      int len = input.length();
      for (int i = 1; i <= len; i++) {
        String prefix = input.substring(0, i);
        if (dict.contains(prefix)) {
          String suffix = input.substring(i, len);
          ArrayList<String> segSuffix = wordBreakDfs(suffix, dict,memoized);
          for (String suf : segSuffix) {
              if (suf.equals("")) {
                  ans.add(prefix);
              } else {
                ans.add(prefix + " " + suf);
              }
          }
        }
      }
      memoized.put(input, ans);
      return ans;
    }
}

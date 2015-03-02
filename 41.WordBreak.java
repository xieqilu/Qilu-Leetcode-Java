/**
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

/**
 * Solution:
 * Do not use Recursive solution to solve the problem, it's very inefficient.
 * Use Iterative Dynamic Programming approach as follows:
 * 
 * Use a bool array dp to keep track of which part of the input string is already matched.
 * The size of bool array is the size of Set+1. And dp[i] is true means all the chars of 
 * s (input string) before s[i] is already matched. So initiliaze dp[0] as true, then we
 * can start matching from s[0].
 * 
 * Then iterate through each char of s, for each char s[i], check if dp[i] is true. If dp[i]
 * is false, no need to do match from current position. If dp[i] is true, which means all the
 * chars before s[i] are already matched. So we try to match chars from s[i].
 * 
 * To match chars from s[i], we iterate through dict. For each string str, try to match
 * s.substring(i,i+str.length()) with str. If matched, set dp[i+str.length()] to true and 
 * check if i+str.length() is equal to s.length(), if it is, then all chars of s are matched,
 * we break the loop. If not matched, continue.
 * 
 * After the above nested loop, return dp[s.length()], which indicates if all chars of s are matched
 * or not.
 * 
 * 
 * Time Complexity: O(n*m), n is the size of input string, m is the size of input dict
 * Space Complexity: O(n), n is the size of input string.
 * 
 * */

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1]; 
        dp[0] = true; //suppose the char before s[0] is matched
        for(int i=0;i<s.length();i++){ //iterate through each char of s
            if(dp[i]){ //dp[i] is true means the char before s[i] can be matched
                for(String str : dict){ //try to match the rest of char using each strings in dict
                    int len = str.length();
                    int end = i+len;
                    if(end<=s.length() && !dp[end]){ //if dp[end] is already true, don't match again
                        if(s.substring(i,end).equals(str)){
                            dp[end]=true;
                            if(end == s.length())
                                return true; //if all chars are matched, directly return true
                        }
                    }
                }
            }
        }
        //if in the above loop, method not return, then not all chars are matched
        //return false
        return false; 
    }
}

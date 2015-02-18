/**
Reverse a string
Example:  "Hello I am a boy"
output:  "boy a am I Hello"

Clarification:

What constitutes a word?
A sequence of non-space characters constitutes a word.

Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.

How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

Solution:
Basic idea: Reversely traverse the given string and for each word,
reversely append the char to the new stringBuilder.
After the loop, append the last word to the stringBuilder

To get rid of the leading, trailing and concecutive duplicate spaces,
we need to preprocess the string to remove all leading, trailing and concecutive 
duplicate spaces

 * Leetcode better solution:
 * In java, String.substring() method can take two arguments.
 * For example, String.substring(a,b) will get the substring starting
 * at index a and ending at index (b-1).
 * 
 * So we can iterate the given string in one pass and keep track of the 
 * starting and ending (a and b) position of a word, then append each word
 * to StringBuilder.
 * 
 * In detail:
 * we use int j to keep track of ending position of a word. In the loop, if 
 * current char is ' ', we let j=i. So that j would ignore all leading, trailing
 * or concecutive duplicate space and move with i. Until current char is not space,
 * j will stay at the last space found, then we check if s.charAt(i-1) is ' ' or i==0.
 * If it is, we found a word, then append the word to StringBuilder.
 * 
*/


public class Solution {
    //Leetcode official solution which is much simpler and better than mine!!
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j=s.length();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' ')
                j=i;
            else if(i==0 || s.charAt(i-1)==' '){
                if(reversed.length()!=0)
                    reversed.append(' ');
                reversed.append(s.substring(i,j));
            }
        }
        return reversed.toString();
    }
    
    private boolean IsAllSpace(String s){  //check if s only contains spaces
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                return false;
        }
        return true;
    }
    
    public String reverseWords(String s) {
        if(IsAllSpace(s)) //handle edge case
            return "";
            
        List<Character> strlist = new ArrayList<Character>();
        for(int i=0;i<s.length();i++)  //convert s to list of char
            strlist.add(s.charAt(i));
        
        while(strlist.get(0)==' ') //remove all leading spaces of char list
            strlist.remove(0);
        
        while(strlist.get(strlist.size()-1)==' ') //remove all trailing spaces of char list
            strlist.remove(strlist.size()-1);
        
        int prev = 0;
        for(int i=1;i<strlist.size();i++){ //remove all concecutive duplicate spaces of char list
            if(strlist.get(prev)==' ' && strlist.get(i)==' '){
                strlist.remove(i);
                i--;
            }
            else
                prev = i;
        }
        
        StringBuilder sb = new StringBuilder();
        List<Character> charlist = new ArrayList<Character>();
        for(int i=strlist.size()-1;i>=0;i--){
            if(strlist.get(i) == ' '){
                for(int j = charlist.size()-1;j>=0;j--)
                    sb.append(charlist.get(j));
                sb.append(' ');
                charlist.clear();
            }
            else
                charlist.add(strlist.get(i));
        }
        for(int j=charlist.size()-1;j>=0;j--)
            sb.append(charlist.get(j));
        
        return sb.toString();
    }
}

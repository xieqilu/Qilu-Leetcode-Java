/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

/**
 * Solution:
 * The key point to this problem is to compare each number and determine which should be where.
The simplest and most effective way to compare two stings in this case is compare s1+s2 and s2+s1.
If the (int)(s1+s2) > (int)(s2+s1), then s1 should be ahead of s2, otherwise, s2 should be ahead of s1.

In Java, we can use Collections.sort(listname, class comparator) to call custmoized comparator and sort
the list. Detailed steps are as follows:
1, write a class that implements Comparator<T>, and override the method int compare(T x, T y).
2, use Collections.sort(list name, new myComparator()) to sort the list

Note to handle the edge case {0,0,0}, if input array contains only zeros, the output string should
only have one zero.
*/


public class Solution {
    //implement Comparator interface to use customized comparator in Collections.sort()
    class StringComparator implements Comparator<String>{
        @Override
        public int compare(String x, String y){
            String xy = x+y;
            String yx = y+x;
            return (int)(Long.parseLong(xy)-Long.parseLong(yx));
        }
    }
    
    public String largestNumber(int[] num) {
        StringBuilder sb = new StringBuilder();
        List<String> strList = new ArrayList<String>();
        for(int i :num)
            strList.add(""+i); //easist way to convert int to string
        //use customized comparator class to sort strList
        Collections.sort(strList, new StringComparator());
        
        boolean IsLeadingZero = true;
        for(int i=strList.size()-1;i>=0;i--){
            if(IsLeadingZero && strList.get(i).equals("0")) //use equals to compare strings in java
                continue;
            IsLeadingZero = false;
            sb.append(strList.get(i));
        }
        
        if(sb.length()==0)
            return "0";
        return sb.toString();
        
    }
}

/**
 * Design and implement a TwoSum class. It should support the following operations: 
 * add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false


Solution:
use a HashMap, key is the number and value is the number of this elements(count) 
in the Data Structure.
add: if element is already in the map, increment the count. Otherwiese, add
(element,1) to the map.
find: for each element in map, check if value-element exist in the map. If not,
then return false. If exists, then if and only if value-element==element and 
the count of element is 1, return false. Otherwise, return true.
*/

public class TwoSum {
    private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	public void add(int number) {
	    if(map.containsKey(number))
	        map.put(number,map.get(number)+1);
	    else
	        map.put(number,1);
	}

	public boolean find(int value) {
	    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
	        int i = entry.getKey();
	        if(map.containsKey(value-i)){
	            if(value-i==i&&map.get(value-i)==1)
	                return false;
	            return true;
	        }
	    }
	    return false;
	}
}

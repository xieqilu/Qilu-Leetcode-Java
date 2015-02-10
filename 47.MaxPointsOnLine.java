/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
 /**
 Input Edge cases:
 1 only one point in array
 2 all points in array are duplicate
 3 no point in array
 */
public class Solution {
    public int maxPoints(Point[] points) {
            //in the hashmap, value is Integer, which is a class
            //when adding int to the map, compiler will autobox it to Integer object
        	HashMap<Float, Integer> dic = new HashMap<Float, Integer> ();
			int MaxNum = 0;
			int duplicate;
			for (int i = 0; i < points.length; i++) {
				dic.clear (); //clear dic each time
				duplicate = 1; //reset duplicate flag
				for (int j = 0; j < points.length; j++) {
					if (i == j) //skip the point itself
						continue;

					//handle duplicate
					if (points [i].x == points [j].x && points [i].y == points [j].y) {
						duplicate++;
						continue;
					}

					//handle non-duplicate points
					float key = (points [j].x - points [i].x == 0) ? Integer.MAX_VALUE : //handle vertical
						(float)(points [j].y - points [i].y) / (points [j].x - points [i].x);
						
          //if only one point in the array or all points are duplicate, dic 
				//will contain no pair, but the output should be 1 or more, because if all points
				//are the same they still at the same line. so we need to handle this case!!
					if (dic.containsKey (key))
						dic.put(key, dic.get(key)+1);
					else {
						dic.put (key, 1);
					}
				}
				
				if(dic.isEmpty()){
				    if(duplicate > MaxNum)
				        MaxNum = duplicate;
				        continue;
				}

				//Shows How to iterate an unordered data strucutre
				Iterator it = dic.entrySet().iterator();
				while(it.hasNext())
				{
				    Map.Entry pairs = (Map.Entry)it.next();
				    //when get value from pair, need to convert Integer object
				    //to int by typecasting
				    if(((int)pairs.getValue() + duplicate )> MaxNum) 
				        MaxNum = (int)pairs.getValue() + duplicate;
				}
			}
			return MaxNum;
    }
}

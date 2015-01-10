/*
you can try using this code to start and run some of your own tests
make sure that you do NOT submit this code otherwise your tests will fail.
also beware that iterators do not necessarily have to come from a backing list.
take time with your corner cases.
anonymous inner classes might help although you don't have to use it. 
NO need to support delete operation
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Solution {
	public static void main(String args[]) throws Exception {
		List<Iterator<String>> lists = new ArrayList<>();
		lists.add(Arrays.asList("a", "b", "c").iterator());
		lists.add(null);
		lists.add(Arrays.<String>asList().iterator());
		lists.add(Arrays.asList("d", "e").iterator());
		lists.add(Arrays.<String>asList().iterator());
		
		Iterator<Iterator<String>> iters = lists.iterator();
		Iterator<String> flattened = flatten(iters);
		while (flattened.hasNext()) {
			System.out.println(flattened.next());
		}
	}

	public static Iterator<String> flatten(final Iterator<Iterator<String>> iters){
		return new Iterator<String>() {	
            private Iterator<String> curIter=null;
            private String nextItem=advanceItem();
            private String advanceItem(){
                if(iters==null&&curIter==null) throw new NullPointerException();
                while((iters!=null&&iters.hasNext())||(curIter!=null&&curIter.hasNext())){
                    if((curIter==null||!curIter.hasNext())){
                        if(iters!=null&&iters.hasNext()){
                            curIter=iters.next();
                        }
                    }
                    if(curIter==null){
                        continue;
                    }
                    while(curIter.hasNext()){
                        String result=curIter.next();
                        if(result!=null){
                            return result;
                        }
                    }
                }
                return null;
            }
			public boolean hasNext() {
				return nextItem!=null;
			}

			public String next() {
				if(!hasNext())
                    throw new NullPointerException();
                String oldItem=nextItem;
                nextItem=advanceItem();
                return oldItem;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		//return null;
	}
}



/** @return Iterator which flattens the given arguments 
public static Iterator<String> flatten(final Iterator<Iterator<String>> iters) {
		return new Iterator<String>() {	
            private Iterator<String> curIter=null;
            private String nextItem=advanceItem();
            private String advanceItem(){
                if(iters==null&&curIter==null) throw new NullPointerException();
                while((iters!=null&&iters.hasNext())||(curIter!=null&&curIter.hasNext())){
                    if((curIter==null||!curIter.hasNext())){
                        if(iters!=null&&iters.hasNext()){
                            curIter=iters.next();
                        }
                    }
                    if(curIter==null){
                        continue;
                    }
                    while(curIter.hasNext()){
                        String result=curIter.next();
                        if(result!=null){
                            return result;
                        }
                    }
                }
                return null;
            }
			public boolean hasNext() {
				return nextItem!=null;
			}

			public String next() {
				if(!hasNext())
                    throw new NullPointerException();
                String oldItem=nextItem;
                nextItem=advanceItem();
                return oldItem;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
}*/


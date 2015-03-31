/**
Implement MyQueue class which implements a queue using two stacks.


Solution:
The major difference between a stack and a queue is the order(FIFO and LIFO).
So we can use the second stack to reverse the order of the elements (by poping
the first stack and pushing elements into second stack). In such an implementation,
on each peek() and remove() operation, we would pop everything from first stack
to second stack, perform the peek/pop operation and then push everything back.

This will work but cost us needless movement of elements. We can let the elements 
sit in the second stack until we absolutely must reverse the elements. Because we only
need to make sure the eek() and remove() method will return the first element of the
queue.

So stackNewest has the newest elements on top and stackOldest has the oldes elements on
top. When we dequeue an element, we want to remove the oldest element first, and so we 
dequeue from stackOldest. Only if stackOldest is empty, then we want to transfer all 
elements from stackNewest into this stack in reverse order. When Enqueue elements, we
always push it to stackNewest.
*/



import java.util.*;
public class MyQueue<T> {
	Stack<T> stackNewest, stackOldest;
	
	public MyQueue(){
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size(){
		return stackNewest.size()+stackOldest.size();
	}
	
	public void add(T item){
		stackNewest.push(item);
	}
	
	private void shiftStacks(){
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty())
				stackOldest.push(stackNewest.pop());
		}
	}
	
	public T peek(){
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove(){
		shiftStacks();
		return stackOldest.pop();
	}
}

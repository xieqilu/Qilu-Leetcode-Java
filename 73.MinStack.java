//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.


class MinStack {
    private Stack<Integer> generalStack = new Stack<Integer>();
    private Stack<Integer> minimumStack = new Stack<Integer>();
    public void push(int x) {
        generalStack.push(x);
        if(minimumStack.empty() || x<=minimumStack.peek())
            minimumStack.push(x);
    }

    public void pop() {
        if(generalStack.empty())
            return;
        int tmp = generalStack.pop();
        if(minimumStack.peek()==tmp)
            minimumStack.pop();
    }

    public int top() {
        if(generalStack.empty())
            return 1;
        return generalStack.peek();
    }

    public int getMin() {
        if(minimumStack.empty())
            return 1;
        return minimumStack.peek();
    }
}

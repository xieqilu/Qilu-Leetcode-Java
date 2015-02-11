//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

//Question to ask the interviewer
//How to handle the division by 0 situation?


//Note: we can use '0'=<char<='9' to ensure the char is a number

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for(String s : tokens){
            if((s.charAt(0) =='-' && s.length()>1) || (s.charAt(0)>='0'&&s.charAt(0)<='9'))
                st.push(Integer.valueOf(s));
            else{
                int firstNum = st.pop();
                int secondNum = st.pop();
                int result = 0;
                if(s.equals("+"))
                    result = secondNum + firstNum;
                else if(s.equals("-"))
                    result = secondNum - firstNum;
                else if(s.equals("*"))
                    result = secondNum * firstNum;
                else if(s.equals("/"))
                    result = secondNum/firstNum;
                st.push(result);
            }
        }
        return st.pop();
    }
}

import java.util.*;

//AB4 逆波兰表达式求值
public class Solution {
    public int evalRPN (String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(cal(n1,n2,s));
            }else
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
    public int cal(int num1, int num2, String c){
        switch(c){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
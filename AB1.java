import java.util.Scanner;
//AB1 【模板】栈
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack1 stack = new Stack1(n);
        while(scanner.hasNextLine()){
            String in = scanner.nextLine();
            if("pop".equals(in)){
                System.out.println(stack.pop());
            }else if("top".equals(in)){
                System.out.println(stack.top());
            }else{
                String[] s = in.split(" ");
                if(s[0].equals("push"))
                    stack.push(Integer.parseInt(s[1]));
            }
        }
    }
    
}
class Stack1{
    private int[] stack;
    private int index = 0;
    public Stack1(int n){
        stack = new int[n];
    }
    public void push(int n){
        stack[index++] = n;
    }
    public String pop(){
        if(index == 0)return "error";
        else{
            return stack[--index] + "";
        }
    }
    public String top(){
        if(index == 0)return "error";
        else{
            int i = index - 1;
            return stack[i] + "";
        }
    }
}
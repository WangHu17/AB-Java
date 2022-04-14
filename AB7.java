import java.util.*;
//AB7 【模板】队列
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MyQueue queue = new MyQueue(n);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if("pop".equals(s)){
                queue.pop();
            }else if("front".equals(s)){
                queue.front();
            }else{
                String[] split = s.split(" ");
                if(split[0].equals("push"))
                    queue.push(Integer.parseInt(split[1]));
            }
        }
    }
    
}

class MyQueue{
    private int maxSize;
    private int front = 0;
    private int rear = 0;
    private int arr[];
    
    public MyQueue(int n){
        maxSize = n;
        arr = new int[maxSize];
    }
    
    public void push(int x){
        arr[rear++] = x;
    }
    
    public void pop(){
        if(front == rear){
            System.out.println("error");
            return;
        }
        System.out.println(arr[front++]);
    }
    
    public void front(){
        if(front == rear){
            System.out.println("error");
            return;
        }
        System.out.println(arr[front]);
    }
}
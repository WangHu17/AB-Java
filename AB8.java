import java.util.*;
//AB8 【模板】循环队列
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();    
        int n1 = scanner.nextInt();  
        CircleQueue queue = new CircleQueue(n+1);
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
class CircleQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public CircleQueue(int n){
        maxSize = n;
        arr = new int[n];
    }
    public void push(int x){
        if((rear+1)%maxSize == front){
            System.out.println("full");
            return;
        }
        arr[rear] = x;
        rear = (rear+1)%maxSize;
    }
    public void pop(){
        if(rear == front){
            System.out.println("empty");
            return;
        }
        System.out.println(arr[front]);
        front = (front+1)%maxSize;
    }
    public void front(){
        if(rear == front){
            System.out.println("empty");
            return;
        }
        System.out.println(arr[front]);
    }
}
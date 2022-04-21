import java.util.*;
//AB18 【模板】堆
public class Main{
    
    private static int length;//数组有效元素的长度
    private static int[] arr;
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String s1 = s.split(" ")[0];
            if(s1.equals("push")){
                int x = Integer.parseInt(s.split(" ")[1]);
                push(x);
            }else if(s1.equals("pop")){
                pop();
            }else if(s1.equals("top")){
                top();
            }
        }
    }
    
    public static void push(int x){
        arr[length++] = x;
        for(int i=length/2-1; i>=0; i--){
            adjustHeap(i);
        }
    }
    
    public static void top(){
        if(length == 0)
            System.out.println("empty");
        else
            System.out.println(arr[0]);
    }
    
    public static void pop(){
        if(length == 0)
            System.out.println("empty");
        else{
            System.out.println(arr[0]);
            arr[0] = arr[length-1];
            length--;
            adjustHeap(0);
        }
    }
    
    public static void adjustHeap(int i){
        int temp = arr[i];
        for(int k = 2*i+1; k<length; k=k*2+1){
            if(k+1 < length && arr[k] < arr[k+1])
                k++;
            if(arr[k] > temp){
                arr[i] = arr[k];
                i=k;
            }else
                break;
        }
        arr[i] = temp;
    }
}
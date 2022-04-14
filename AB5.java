import java.util.*;
//AB5 点击消除
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Deque<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(!queue.isEmpty() && queue.peekLast() == c){
                queue.removeLast();
            }else{
                queue.addLast(c);
            }
        }
        if(queue.isEmpty())System.out.println("0");
        else{
            while(!queue.isEmpty()){
                System.out.print(queue.peekFirst());
                queue.removeFirst();
            }
        }
    }
    
}
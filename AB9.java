import java.util.*;
//AB9 【模板】链表
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();    
        LinkedList linkedList = new LinkedList();
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            if("insert".equals(split[0])){
                int x = Integer.parseInt(split[1]);
                int y = Integer.parseInt(split[2]);
                linkedList.insert(x,y);
            }else if("delete".equals(split[0])){
                int x = Integer.parseInt(split[1]);
                linkedList.delete(x);
            }
        }
        linkedList.show();
    }
    
}
class LinkedList{
    private Node head;
    public LinkedList(){
        head = new Node(-1);
    }
    
    public void insert(int x, int y){
        Node t = head;
        Node node = new Node(y);
        while(t.next != null){
            if(t.next.val == x){
                break;
            }
            t = t.next;
        }
        node.next = t.next;
        t.next = node;
    }
    public void delete(int x){
        Node t = head;
        while(t.next != null){
            if(t.next.val == x){
                t.next = t.next.next;
                break;
            }
            t = t.next;
        }
    }
    public void show(){
        Node t = head.next;
        if(t == null){
            System.out.print("NULL");
            return;
        }
        while(t != null){
            System.out.print(t.val + " ");
            t = t.next;
        }
    }
}
class Node{
    public int val;
    public Node next;
    public Node(int x){
        this.val = x;
    }
}
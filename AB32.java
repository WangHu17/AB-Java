import java.util.*;
//AB32 【模板】哈夫曼编码
public class Main{
    
//     private static Map<String,String> res = new HashMap<>();
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            Long a = scanner.nextLong();
            queue.add(a);
        }
        long sum = 0;
        while(queue.size() > 1){
            Long n1 = queue.poll();
            Long n2 = queue.poll();
            sum += (n1 + n2);
            queue.add(n1 + n2);
        }
        System.out.println(sum);
    }
}
    
//     public static void main(String[] args){
//         Scanner scanner = new Scanner(System.in);
//         int n = scanner.nextInt();
//         int[] arr = new int[n];
//         for(int i=0; i<n; i++){
//             arr[i] = scanner.nextInt();
//         }
//         Node node = createHuffmanTree(arr);
//         getCodes(node.left,"0",new StringBuilder());
//         getCodes(node.right,"1",new StringBuilder());
//         int len = 0;
//         for(String key:res.keySet()){
//             String[] split = key.split("-");
//             int num = Integer.parseInt(split[1]);
//             len += num * res.get(key).length();
//         }
//         System.out.println(len);
//     }
    
//     public static Node createHuffmanTree(int[] arr){
//         ArrayList<Node> list = new ArrayList<>();
//         for(int i=0; i<arr.length; i++){
//             Node node = new Node(i, arr[i]);
//             list.add(node);
//         }
//         while(list.size() > 1){
//             Collections.sort(list);
//             Node o1 = list.get(0);
//             Node o2 = list.get(1);
//             Node p = new Node(null, o1.value + o2.value);
//             p.left = o1;
//             p.right = o2;
//             list.remove(o1);
//             list.remove(o2);
//             list.add(p);
//         }
//         return list.get(0);
//     }
    
//     public static void getCodes(Node node, String code, StringBuilder builder){
//         StringBuilder builder2 = new StringBuilder(builder);
//         builder2.append(code);
//         if(node != null){
//             if(node.data == null){
//                 getCodes(node.left, "0", builder2);
//                 getCodes(node.right, "1", builder2);
//             }else{
//                 res.put(node.data + "-" + node.value, builder2.toString());
//             }
//         }
//     }
    
// }
// class Node implements Comparable<Node>{
//     Integer data;
//     int value;
//     Node left;
//     Node right;

//     public Node(Integer data, int value){
//         this.value = value;
//         this.data = data;
//     }

//     @Override
//     public int compareTo(Node o){
//         return this.value - o.value;
//     }
// }
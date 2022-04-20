import java.util.*;
//AB39 [NOIP2001]装箱问题
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        int n = scanner.nextInt();
        int[] goods = new int[n];
        for(int i=0; i<n; i++){
            goods[i] = scanner.nextInt();
        }
        int[] dp = new int[capacity + 1];
        for(int i=0; i<n; i++){
            for(int j=capacity; j>=goods[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - goods[i]] + goods[i]);
            }
        }
        System.out.println(capacity - dp[capacity]);
    }
    
}
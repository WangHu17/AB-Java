import java.util.*;
//AB40 【模板】01背包
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int capacity = Integer.parseInt(s.split(" ")[1]);
        int[][] goods = new int[n][2];
        for(int i=0; i<n; i++){
            String t = scanner.nextLine();
            goods[i][0] = Integer.parseInt(t.split(" ")[0]);
            goods[i][1] = Integer.parseInt(t.split(" ")[1]);
        }
        int res1 = maxVal(capacity, goods);
        int res2 = maxValOfFull(capacity, goods);
        System.out.println(res1);
        System.out.println(res2);
    }
    
    public static int maxVal(int capacity, int[][] goods){
        int[] dp = new int[capacity + 1];
        for(int i=0; i<goods.length; i++){
            for(int j=capacity; j>= goods[i][0]; j--){
                dp[j] = Math.max(dp[j], dp[j - goods[i][0]] + goods[i][1]);
            }
        }
        return dp[capacity];
    }
    
    public static int maxValOfFull(int capacity, int[][] goods){
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int i=0; i<goods.length; i++){
            for(int j=capacity; j>= goods[i][0]; j--){
                dp[j] = Math.max(dp[j], dp[j - goods[i][0]] + goods[i][1]);
            }
        }
        return dp[capacity] < 0 ? 0 : dp[capacity];
    }
    
}
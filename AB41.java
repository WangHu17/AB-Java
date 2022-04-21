import java.util.*;
//AB41 【模板】完全背包
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
        int n = goods.length;
        int[][] dp = new int[n+1][capacity+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<capacity+1; j++){
                int max = dp[i-1][j];
                for(int k=0; k*goods[i-1][0] <= j; k++){
                    max = Math.max(max, k*goods[i-1][1] + dp[i-1][j - k*goods[i-1][0]]);
                }
                dp[i][j] = max;
            }
        }
        return dp[n][capacity];
    }
    public static int maxValOfFull(int capacity, int[][] goods){
        int n = goods.length;
        int[][] dp = new int[n+1][capacity+1];
        for(int j=1; j<capacity+1; j++){
            dp[0][j] = Integer.MIN_VALUE;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<capacity+1; j++){
                int max = dp[i-1][j];
                for(int k=0; k*goods[i-1][0] <= j; k++){
                    max = Math.max(max, k*goods[i-1][1] + dp[i-1][j - k*goods[i-1][0]]);
                }
                dp[i][j] = max;
            }
        }
        return dp[n][capacity] < 0 ? 0 : dp[n][capacity];
    }
    
}
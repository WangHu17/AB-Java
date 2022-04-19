import java.util.*;
//AB37 最长上升子序列(一)
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(longest(arr));
    }
    
    public static int longest(int[] arr){
        int max = 0;
        int[] dp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    
}
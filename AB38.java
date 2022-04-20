import java.util.*;
//AB38 最长公共子序列(一)
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int len1 = Integer.parseInt(s.split(" ")[0]);
        int len2 = Integer.parseInt(s.split(" ")[1]);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        if(len1 == 0 || len2 == 0){
            System.out.println(0);
            return;
        }
        System.out.println(LCS(s1, s2, len1, len2));
    }
    
    public static int LCS(String s1, String s2, int len1, int len2){
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i=1; i<len1+1; i++){
            for(int j=1; j<len2+1; j++){
                dp[i][j] = s1.charAt(i-1)==s2.charAt(j-1) ? 
                    dp[i-1][j-1]+1 : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int res = 0;
        for(int i=len1, j=len2; dp[i][j] >= 1;){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                res++;
                i--;
                j--;
            }else if(dp[i-1][j] >= dp[i][j-1]){
                i--;
            }else
                j--;
        }
        return res;
    }
}
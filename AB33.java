import java.util.*;
//AB33 相差不超过k的最多数
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        int res = select(arr, m);
        System.out.println(res);
    }
    
    public static int select(int[] arr, int m){
        Arrays.sort(arr);
        int max = 0, l = 0, r = 1;
        while(r < arr.length){
            while(arr[r] - arr[l] > m)l++;
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
    
}
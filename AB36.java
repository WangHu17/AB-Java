import java.util.*;
//AB36 连续子数组最大和
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxSum(arr));
    }
    
    public static int maxSum(int[] arr){
        int sum = arr[0], max = arr[0];
        for(int i=1; i<arr.length; i++){
            sum += arr[i];
            if(sum < arr[i]){
                sum = arr[i];
                if(max < sum)max = sum;
            }else
                if(max < sum)max = sum;
        }
        return max;
    }
    
}
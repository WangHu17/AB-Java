import java.util.*;
//AB31 活动安排
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] time = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++)
                time[i][j] = scanner.nextInt();
        }
        Arrays.sort(time, (a,b)->a[1] - b[1]);
        int res = 1, j=0;
        for(int i=1; i<n; i++){
            if(time[i][0] >= time[j][1]){
                res++;
                j=i;
            }
        }
        System.out.println(res);
    }
}
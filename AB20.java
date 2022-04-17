import java.util.*;
//AB20 走迷宫
public class Main{
    
    private static int[][] step;
    private static char[][] grid;
    private static int end1;
    private static int end2;
    private static int row;
    private static int col;
    private static Queue<int[]> queue = new LinkedList<>();
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        row = Integer.parseInt(s1[0]);
        col = Integer.parseInt(s1[1]);
        grid = new char[row][col];
        step = new int[row][col];
        String[] s2 = scanner.nextLine().split(" ");
        int x = Integer.parseInt(s2[0])-1;
        int y = Integer.parseInt(s2[1])-1;
        end1 = Integer.parseInt(s2[2])-1;
        end2 = Integer.parseInt(s2[3])-1;
        for(int i=0; i<row; i++){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for(int j=0; j<col; j++){
                grid[i][j] = chars[j];
            }
        }
        if(grid[x][y] == '*' || grid[end1][end2] == '*'){
            System.out.println(-1);
            return;
        }
        int[] point = {x,y};
        queue.add(point);
        System.out.println(migong(x,y));
    }
    
    public static int migong(int x, int y){
        while(!queue.isEmpty()){
            int[] next = queue.poll();
            int n1 = next[0], n2 = next[1];
            if(n1 == end1 && n2 == end2)break;
            if(n1 - 1 >= 0 && grid[n1-1][n2] == '.'){
                int[] point = {n1 - 1, n2};
                queue.add(point);
                step[n1-1][n2] = step[n1][n2] + 1;
                grid[n1-1][n2] = '*';
            }
            if(n1 + 1 < row && grid[n1+1][n2] == '.'){
                int[] point = {n1 + 1, n2};
                queue.add(point);
                step[n1+1][n2] = step[n1][n2] + 1;
                grid[n1+1][n2] = '*';
            }
            if(n2 - 1 >= 0 && grid[n1][n2-1] == '.'){
                int[] point = {n1, n2 - 1};
                queue.add(point);
                step[n1][n2-1] = step[n1][n2] + 1;
                grid[n1][n2-1] = '*';
            }
            if(n2 + 1 < col && grid[n1][n2+1] == '.'){
                int[] point = {n1, n2 + 1};
                queue.add(point);
                step[n1][n2+1] = step[n1][n2] + 1;
                grid[n1][n2+1] = '*';
            }
        }
        return step[end1][end2] == 0 ? -1 : step[end1][end2];
    }
    
}
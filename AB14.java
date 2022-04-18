import java.util.*;

//AB14 最小生成树
public class Solution {
    
    public int miniSpanningTree (int n, int m, int[][] cost) {
        Graph graph = new Graph(m, cost);
        return graph.kruskal();
    }
    
    class Graph{
        private int n;
        private int[][] edges;
        private int sum;
        
        public Graph(int n, int[][] arr){
            this.n = n;
            edges = arr;
        }
        
        public int kruskal(){
            Arrays.sort(edges, (a, b) -> a[2] - b[2]);
            int[] ends = new int[n + 1];
            for(int i=0; i<n; i++){
                int end1 = getEnd(ends, edges[i][0]);
                int end2 = getEnd(ends, edges[i][1]);
                if(end1 != end2){
                    ends[end1] = end2;
                    sum += edges[i][2];
                }
            }
            return sum;
        }
        
        private int getEnd(int[] ends, int i){
            while(ends[i] != 0){
                i = ends[i];
            }
            return i;
        }
    }
}
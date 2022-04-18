import java.util.*;
//AB26 汉诺塔问题
public class Solution {
    ArrayList<String> res;
    public ArrayList<String> getSolution(int n) {
        res = new ArrayList<>();
        hanoitower(n,"left","mid","right");
        return res;
    }
    
    public void hanoitower(int n,String a,String b, String c){
        if(n==1){
            res.add("move from " + a + " to " + c);
        }else{
            hanoitower(n-1,a,c,b);
            res.add("move from " + a + " to " + c);
            hanoitower(n-1,b,a,c);
        }
    }
}
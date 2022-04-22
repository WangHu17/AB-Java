import java.util.*;
//AB25 ranko的手表
public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int min = Math.max(1,min(s1,s2));
        int max = max(s1,s2);
        System.out.print(min + " " + max);
    }
    public static int min(String s1, String s2){
        String[] split1 = s1.split(":");
        String h1 = split1[0];
        String m1 = split1[1];
        String[] split2 = s2.split(":");
        String h2 = split2[0];
        String m2 = split2[1];
        char c1 = h1.charAt(0), c2 = h1.charAt(1);
        char c11 = h2.charAt(0), c22 = h2.charAt(1);
        int h=0;
        if(c1 != '?' && c11 != '?' && c2 != '?' && c22 != '?'){
            int H1 = Integer.parseInt(h1);
            int H2 = Integer.parseInt(h2);
            h = H2 - H1;
        }if(c2 != '?' && c22 != '?'){
            if(c2 > c22){
                h = 10 - (c2 - '0') + (c22 - '0');
            }
        }else if(c1 != '?' && c11 != '?'){
            if(c1 == c11){
                h = 0;
            }else{
                if(c2 == '?')c2 = '9';
                if(c22 == '?')c22 = '0';
                h = (c11 - c1 - 1)*10 + 10 - (c2 - '0') + (c22 - '0');
            }
        }else{
           h = 0; 
        } 
        char c3 = m1.charAt(0), c4 = m1.charAt(1);
        char c33 = m2.charAt(0), c44 = m2.charAt(1);
        if(h == 0){
            if(c3 != '?' && c33 != '?' && c3 > c33){
                h = 1;
            }
            if(c3 != '?' && c33 != '?' && c3 == c33){
                if(c4 == '9' || c44 == '0'){
                    h=1;
                }else if(c4 != '?' && c44 != '?' && c4 >= c44){
                    h=1;
                }
            }
        }
        if(c3 == '?' && c4 == '?'){
            m1 = "59";
        }else if(c3 == '?'){
            m1 = "5" + c4;
        }else if(c4 == '?'){
            m1 = c3 + "9";
        }
        if(c33 == '?' && c44 == '?'){
            m2 = "00";
        }else if(c33 == '?'){
            m2 = "0" + c44;
        }else if(c44 == '?'){
            m2 = c33 + "0";
        }
        int M1 = Integer.parseInt(m1);
        int M2 = Integer.parseInt(m2);
        int m = M2 - M1;
        if(M1 >= M2 && h == 0){
            m = 1;
        }else if(M1 > M2 && h != 0){
            h--;
            m = (60-M1) + M2;
        }
        return h*60 + m;
    }
    
    public static int max(String s1, String s2){
        String[] split1 = s1.split(":");
        String h1 = split1[0];
        String m1 = split1[1];
        char c1 = h1.charAt(0), c2 = h1.charAt(1);
        if(c1 == '?' && c2 == '?'){
            h1 = "00";
        }else if(c1 == '?'){
            h1 = "0" + c2;
        }else if(c2 == '?'){
            h1 = c1 + "0";
        }
        int H1 = Integer.parseInt(h1);
        char c3 = m1.charAt(0), c4 = m1.charAt(1);
        if(c3 == '?' && c4 == '?'){
            m1 = "00";
        }else if(c3 == '?'){
            m1 = "0" + c4;
        }else if(c4 == '?'){
            m1 = c3 + "0";
        }
        int M1 = Integer.parseInt(m1);
        String[] split2 = s2.split(":");
        String h2 = split2[0];
        String m2 = split2[1];
        char c11 = h2.charAt(0), c22 = h2.charAt(1);
        if(c11 == '?' && c22 == '?'){
            h2 = "23";
        }else if(c11 == '?'){
            if(c22 <= '3'){
                h2 = "2" + c22;
            }else
                h2 = "1" + c22;
            
        }else if(c22 == '?'){
            if(c11 == '0' || c11 == '1'){
                h2 = c11 + "9";
            }else
                h2 = "23";
            
        }
        int H2 = Integer.parseInt(h2);
        char c33 = m2.charAt(0), c44 = m2.charAt(1);
        if(c33 == '?' && c44 == '?'){
            m2 = "59";
        }else if(c33 == '?'){
            m2 = "5" + c44;
        }else if(c44 == '?'){
            m2 = c33 + "9";
        }
        int M2 = Integer.parseInt(m2);
        int h = H2-H1;
        int m = M2-M1;
        return h*60 + m;
    }
    
}
package Contest.Test0223.R;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Rtask3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] nmk = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer ::parseInt).toArray();
        int[] p = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer ::parseInt).toArray();
        int[][] m = new int[nmk[1]][2];
        for (int i=0; i<nmk[1]; i++){
            m[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer ::parseInt).toArray();
//            Arrays.sort(m[i]);
        }


        int result = 0;

        for (int i=0; i<m.length; i++){
            if(p[m[i][0] - 1] != p[m[i][1] - 1]){
                if(search(m,m[i][0],m[i][1])){
                    p[m[i][1] - 1] = p[m[i][0] - 1];
                }else {
                    p[m[i][0] - 1] = p[m[i][1] - 1];
                }
                result ++;
            }
        }
        System.out.print(result);

    }

    public static boolean search(int[][] m, int a, int b){
        int aResult = 0;
        int bResult = 0;
        for(int[] j : m){
            for (int i:j){
                if(a == i){
                    aResult++;
                }
                if(b == i){
                    bResult++;
                }
            }
        }
        if(aResult > bResult){
            return true;
        }else
            return false;
    }
}

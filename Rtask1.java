package Contest.Test0223.R;

import java.util.Scanner;

public class Rtask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        char[] buf = new char[10];
        int index = 0;
        String answer = "NO";
        for (char aChar : chars) {
            if (aChar == '?') {
                buf[index] = aChar;
                index++;
            } else {
                boolean flag = true;
                for (int j = 0; j < buf.length; j++) {
                    if (buf[j] == aChar) {
                        buf = new char[10];
                        flag = false;
                        buf[0] = aChar;
                        index = 1;
                        break;
                    } else if (buf[j] == '\u0000') {
                        break;
                    }
                }
                if (flag) {
                    buf[index] = aChar;
                    index++;
                }
            }
            if (index == 10) {
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
        System.out.println("The end!");
    }

}

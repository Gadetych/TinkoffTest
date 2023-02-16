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
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                buf[index] = chars[i];
                index++;
            } else {
                boolean flag = true;
                for (int j = 0; j < buf.length; j++) {
                    if (buf[j] == chars[i]) {
                        buf = new char[10];
                        flag = false;
                        buf[0] = chars[i];
                        index = 1;
                        break;
                    } else if (buf[j] == '\u0000') {
                        break;
                    }
                }
                if (flag) {
                    buf[index] = chars[i];
                    index++;
                }
            }
            if (index == 10) {
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
    }

}

package Contest.Test0223.R;

import java.util.Scanner;

public class Rtask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberDimension = scanner.nextInt();
        scanner.nextLine();
        String[][] dimensions = new String[numberDimension][1];
        for (int i = 0; i < numberDimension; i++) {
            String[] dimension = scanner.nextLine()
                    .split(" ");
            dimensions[i] = dimension;
        }
        scanner.close();

        int currentTemp = 0;
        int maxNegative = 0;
        boolean isPositive;
        for (String[] dimension : dimensions) {
            currentTemp += Integer.parseInt(dimension[0]);
            isPositive = dimension[1].equals("0+");
            if (isPositive) {
                if (currentTemp < 0) {
                    currentTemp = 0;
                    maxNegative = -1;
                }
            } else {
                if (currentTemp >= 0) {
                    currentTemp = -1;
                }
                maxNegative = maxNegative == 0 ? currentTemp : Math.max(maxNegative, currentTemp);

            }
        }
        String answer = maxNegative == 0 ? "inf" : String.valueOf(currentTemp + (-1 - maxNegative));

        System.out.println(answer);
    }
}


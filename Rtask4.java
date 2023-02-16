package Contest.Test0223.R;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rtask4 {
    public static void main(String[] args){
        int filterNumber;
        int[] filterValue;
        int[][] filterChain;
        int[] cableLength;
        int[] result;

        Scanner scanner = new Scanner(System.in);

        filterNumber = Integer.parseInt(scanner.nextLine());

        filterValue = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .toArray();

        filterChain = new int[filterNumber][];
        int[] connectionArray = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < filterNumber; i++) {
            int[] row;
            if (i - 1 >= 0) {
                int filter = connectionArray[i - 1];
                if (filter > 1) {
                    int[] previousConnection = filterChain[filter - 1];
                    row = IntStream.concat(Arrays.stream(new int[]{i + 1}), Arrays.stream(previousConnection))
                            .toArray();
                } else {
                    row = new int[]{i + 1, filter};
                }
            } else {
                row = new int[]{i + 1};
            }
            filterChain[i] = row;
        }

        cableLength = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        result = new int[filterNumber];

        for (int i = 1; i < filterNumber; i++) {
            int sumCableLength = 0;
            for (int j = 0; j < filterChain[i].length - 1; j++) {
                int currentFilter = filterChain[i][j];
                sumCableLength += cableLength[currentFilter - 2];
                if (sumCableLength <= filterValue[filterChain[i][0] - 2]) {
                    result[filterChain[i][j + 1] - 1]++;
                }
            }
        }

//        System.out.println(Arrays.deepToString(filterChain));
//        System.out.println(Arrays.toString(filterValue));
//        System.out.println(Arrays.toString(cableLength));
//        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}

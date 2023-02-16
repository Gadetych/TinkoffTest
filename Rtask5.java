package Contest.Test0223.R;

import java.util.Arrays;
import java.util.Scanner;

public class Rtask5 {
    public static void main(String[] args) {
        int processorNumber;
        int[] processorFrequencies;

        Scanner scanner = new Scanner(System.in);
        processorNumber = scanner.nextInt();
        scanner.nextLine();

        processorFrequencies = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

//        System.out.println(processorNumber);
//        System.out.println(Arrays.toString(processorFrequencies));

        int result = Integer.MIN_VALUE;
        int frequencySum;
        int currentProcessorFrequency;
        for (int i = 0; i < processorNumber; i++) {
            currentProcessorFrequency = processorFrequencies[i];
            if (i > 0) {
                if (processorFrequencies[i - 1] == currentProcessorFrequency) {
                    continue;
                }
            }
            frequencySum = currentProcessorFrequency;
            if (i + 1 < processorNumber) {
                for (int j = i + 1; j < processorNumber; j++) {
                    int division = processorFrequencies[j] / currentProcessorFrequency;
                    int commonProcessorFrequency = currentProcessorFrequency * division;
                    frequencySum += commonProcessorFrequency;
                }
            }
            result = Math.max(frequencySum, result);
        }
        System.out.println(result);
    }
}

import algorithms.PairSum;
import algorithms.SumService;
import algorithms.SumServiceByMap;
import algorithms.SumServiceByPointers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        int requiredSum = 9;
        List<Integer> values = Arrays.asList(4, 3, 1, 1, 5);

        SumService sumServiceByPointers = new SumServiceByPointers();
        SumService sumServiceByMap = new SumServiceByMap();
        Optional<PairSum> pairSumByPointers = sumServiceByPointers.getPairSum(requiredSum, values);
        Optional<PairSum> pairSumByMap = sumServiceByMap.getPairSum(requiredSum, values);

        printResults(sumServiceByPointers, values, requiredSum, pairSumByPointers.orElse(null));
        printResults(sumServiceByMap, values, requiredSum, pairSumByMap.orElse(null));
    }

    private static void printResults(SumService sumService, @NotNull List<Integer> values, int requiredSum, @Nullable PairSum pairSum) {
        if (pairSum == null) {
            System.out.println("Incorrect input array, values not found");
            return;
        }
        System.out.println("Input array : " + Arrays.toString(values.toArray()) + ", target sum: " + requiredSum);
        System.out.println(sumService.getClass().getSimpleName() + ": A: " + pairSum.getFirstNumber() + "; B: " + pairSum.getSecondNumber());
    }
}

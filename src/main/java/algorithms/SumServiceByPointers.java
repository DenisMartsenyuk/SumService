package algorithms;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SumServiceByPointers implements SumService {

    @Override
    public Optional<PairSum> getPairSum(int requiredSum, @NotNull List<Integer> values) {
        List<Integer> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues);

        int leftPointer = 0;
        int rightPointer = sortedValues.size() - 1;

        while (leftPointer < rightPointer) {
            int leftNumber = sortedValues.get(leftPointer);
            int rightNumber = sortedValues.get(rightPointer);

            if (leftNumber + rightNumber == requiredSum) {
                return Optional.of(new PairSum(leftNumber, rightNumber));
            }

            if (leftNumber + rightNumber < requiredSum) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return Optional.empty();
    }
}

package algorithms;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface SumService {
    /**
     * Given an array values of numbers and another number requiredSum,
     * Find two elements in array whose sum is exactly requiredSum.
     *
     * @param requiredSum required sum
     * @param values      input array of numbers
     * @return non-null value PairSum with the pair of numbers whose sum is requiredSum
     * or null if there are no such numbers in values array
     */
    Optional<PairSum> getPairSum(int requiredSum, @NotNull List<Integer> values);
}

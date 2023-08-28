import algorithms.PairSum;
import algorithms.SumService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumServiceTest {

    public static void testNotFoundPairSum(SumService sumService, Integer requiredSum, List<Integer> values) {
        assertTrue(sumService.getPairSum(requiredSum, values).isEmpty());
    }

    public static void testFoundPairSum(SumService sumService, Integer requiredSum, List<Integer> values) {
        Optional<PairSum> pairSum = sumService.getPairSum(requiredSum, values);
        assertTrue(pairSum.isPresent());
        Integer foundSum = pairSum.get().getFirstNumber() + pairSum.get().getSecondNumber();
        assertEquals(requiredSum, foundSum);
    }

    public static void testEmptyValues(SumService sumService) {
        int requiredSum = 0;
        List<Integer> values = List.of();
        assertTrue(sumService.getPairSum(requiredSum, values).isEmpty());
    }
}

import algorithms.SumService;
import algorithms.SumServiceByPointers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SumServiceByPointersTest {

    private static SumService sumService;

    @BeforeAll
    public static void init() {
        sumService = new SumServiceByPointers();
    }

    @Test
    public void testNotFoundPairSum() {
        Integer requiredSum = 10;
        List<Integer> values = Arrays.asList(4, 5);
        SumServiceTest.testNotFoundPairSum(sumService, requiredSum, values);
    }

    @Test
    public void testFoundPairSum() {
        Integer requiredSum = 9;
        List<Integer> values = Arrays.asList(4, 3, 1, 1, 5);
        SumServiceTest.testFoundPairSum(sumService, requiredSum, values);
    }

    @Test
    public void testEmptyValues() {
        SumServiceTest.testEmptyValues(sumService);
    }
}

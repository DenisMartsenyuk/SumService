package algorithms;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SumServiceByMap implements SumService {

    private Map<Integer, Integer> prepareValueCountByValueMap(List<Integer> values) {
        Map<Integer, Integer> valueCountByValueMap = new HashMap<>();
        values.forEach(value -> {
            valueCountByValueMap.computeIfAbsent(value, key -> 0);
            valueCountByValueMap.computeIfPresent(value, (key, val) -> ++val);
        });
        return valueCountByValueMap;
    }

    private boolean isRequiredNumberFound(int requiredSum, int sourceNumber, Map<Integer, Integer> valuesMap) {
        int requiredNumber = requiredSum - sourceNumber;
        return valuesMap.containsKey(requiredNumber) && (requiredNumber != sourceNumber || valuesMap.get(requiredNumber) > 1);
    }

    @Override
    public Optional<PairSum> getPairSum(int requiredSum, @NotNull List<Integer> values) {
        Map<Integer, Integer> valueCountByValueMap = prepareValueCountByValueMap(values);

        return values.stream()
                .filter(sourceNumber -> isRequiredNumberFound(requiredSum, sourceNumber, valueCountByValueMap))
                .findFirst()
                .map(requiredNumber -> new PairSum(requiredSum - requiredNumber, requiredNumber));
    }
}

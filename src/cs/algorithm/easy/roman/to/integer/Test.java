package cs.algorithm.easy.roman.to.integer;

import java.util.List;

public class Test {
    private static final List<String> testCases = List.of("III", "IV", "IX", "LVIII", "MCMXCIV");

    public static void main(String[] args) {
        testCases.forEach(symbol -> System.out.println(new Solution().romanToInt(symbol)));
    }
}

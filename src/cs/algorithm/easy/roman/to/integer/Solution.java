package cs.algorithm.easy.roman.to.integer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: s = "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: s = "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class Solution {

    private static final List pattern = List.of('I', 'V', 'X', 'L', 'C', 'D', 'M');
    private static final Map<Character, Integer> mapping =
            Map.of('I', 1,
                    'V', 5,
                    'X', 10,
                    'L', 50,
                    'C', 100,
                    'D', 500,
                    'M', 1000);

    public int romanToInt(String symbol) {
        if (null == symbol || symbol.isEmpty() || symbol.length() > 15) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<>();
        for (char c : symbol.toCharArray()) {
            if (!pattern.contains(c)) throw new IllegalArgumentException();
            list.add(mapping.get(c));
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 == list.size()) {
                result += list.get(i);
            } else if (list.get(i) < list.get(i + 1)) {
                result += -list.get(i);
            } else {
                result += list.get(i);
            }
        }
        return result;
    }

}

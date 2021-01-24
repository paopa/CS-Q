package cs.algorithm.easy.longest.common.prefix;

/**
 * 14. Longest Common Prefix
 * Easy
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int index = strs[0].length();
        if (index == 0) return "";
        for (int i = 1; i < strs.length; i++) {
            index = Math.min(index, compare(strs[0], strs[i], index));
            if (index == 0) break;
        }
        return strs[0].substring(0, index);
    }

    private int compare(String str, String str1, int index) {
        index = (str.length() > str1.length()) ? str1.length() : index;
        while (index > 0) {
            if (str1.startsWith(str.substring(0, index))) {
                break;
            }
            index--;
        }
        return index;
    }
}

class Test {
    public static void main(String[] args) {
//        var input = new String[]{"flower", "flow", "flight"};
//        var input = new String[]{"dog","racecar","car"};
//        var input = new String[]{"reflower", "flow", "flight"};
        var input = new String[]{"ab", "a"};
//        var input = new String[]{""};
//        var input = new String[]{};
        System.out.println(new Solution().longestCommonPrefix(input));
    }
}

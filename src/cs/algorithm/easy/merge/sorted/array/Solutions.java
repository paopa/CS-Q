package cs.algorithm.easy.merge.sorted.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 88. Merge Sorted Array
 * Easy
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * <p>
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public abstract class Solutions {

    public abstract void merge(int[] nums1, int m, int[] nums2, int n);

    public static Solutions factory(String solution) {
        switch (solution) {
            case "1":
                return new Solution1();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Solution1 extends Solutions {

        @Override
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n == 0) return;
            int p = nums1.length - 1;
            m--;
            n--;
            while (p >= 0 && n >= 0) {
                if (m >= 0 && nums1[m] > nums2[n]) nums1[p--] = nums1[m--];
                else nums1[p--] = nums2[n--];
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        List.of(
                new TestCase(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3),
                new TestCase(new int[]{1}, 1, new int[]{}, 0),
                new TestCase(new int[]{5, 6, 7, 0, 0, 0}, 2, new int[]{1, 2, 5, 6}, 4)
        ).forEach(test -> {
            Solutions.factory("1").merge(test.nums1, test.m, test.nums2, test.n);
            System.out.println(Arrays.stream(test.nums1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",", "[", "]")));
        });
    }

    private static class TestCase {

        int[] nums1;
        int m;
        int[] nums2;
        int n;

        public TestCase(int[] nums1, int m, int[] nums2, int n) {
            this.nums1 = nums1;
            this.m = m;
            this.nums2 = nums2;
            this.n = n;
        }
    }
}

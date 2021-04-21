package cs.algorithm.easy.remove.duplicates.from.sorted.list;

import java.util.List;

import static java.util.Objects.isNull;

/**
 * 83. Remove Duplicates from Sorted List
 * Easy
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public abstract class Solutions {
    public abstract ListNode deleteDuplicates(ListNode head);

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode current = head;
            while (!isNull(current)) {
                if (!isNull(current.next) && current.val == current.next.val) {
                    current.next = current.next.next;
                    continue;
                }
                current = current.next;
            }
            return head;
        }
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        List.of(
                new TestCase(TestCase.case1()),
                new TestCase(TestCase.case2())
        ).forEach(test -> System.out.println(Solutions.factory("1").deleteDuplicates(test.root)));
    }

    private static class TestCase {
        ListNode root;

        public TestCase(ListNode root) {
            this.root = root;
        }

        public static ListNode case1() {
            return new ListNode(1, new ListNode(1, new ListNode(2)));
        }

        public static ListNode case2() {
            return new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        }
    }
}

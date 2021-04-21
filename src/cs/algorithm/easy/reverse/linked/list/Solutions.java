package cs.algorithm.easy.reverse.linked.list;

import java.util.List;

import static java.util.Objects.isNull;

/**
 * 206. Reverse Linked List
 * Easy
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public abstract class Solutions {

    public abstract ListNode reverse(ListNode head);

    public static Solutions factory(String solution) {
        if (isNull(solution)) {
            throw new IllegalArgumentException();
        }
        switch (solution) {
            case "1":
                return new Solution1();
            case "2":
                return new Solution2();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * iterative
     * time complexity: O(n)
     * space complexity: O(1)
     */
    private static class Solution1 extends Solutions {

        @Override
        public ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next;
            while (!isNull(curr)) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    /**
     * recursive
     * time complexity: O(n)
     * space complexity: O(n)
     */
    private static class Solution2 extends Solutions {

        @Override
        public ListNode reverse(ListNode head) {
            if (isNull(head) || isNull(head.next)) {
                return head;
            }
            ListNode node = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

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
        ).forEach(test -> System.out.println(Solutions.factory("2").reverse(test.root)));
    }

    private static class TestCase {
        ListNode root;

        public TestCase(ListNode root) {
            this.root = root;
        }

        public static ListNode case1() {
            return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        }

        public static ListNode case2() {
            return new ListNode(1);
        }
    }
}

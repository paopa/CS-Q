package cs.algorithm.easy.node.reverse;

import static java.util.Objects.isNull;

/**
 * singly-linked node reverse
 */
public abstract class Solutions {

    public abstract ListNode reverse(ListNode node);

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
        public ListNode reverse(ListNode node) {
            ListNode prev = null;
            ListNode current = node;
            ListNode next;
            while (!isNull(current)) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
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

class Test {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4))));
        System.out.println(Solutions.factory("2").reverse(test1));
    }
}

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

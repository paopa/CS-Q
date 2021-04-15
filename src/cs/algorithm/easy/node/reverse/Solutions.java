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
            default:
                throw new IllegalArgumentException();
        }
    }

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
}

class Test {
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(Solutions.factory("1").reverse(test1));
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

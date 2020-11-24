package cs.algorithm.medium.addtwonumbers;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 * <p>
 * link: https://leetcode.com/problems/add-two-numbers/
 */
public class Solution {

    private final static ListNode zeroNode = new ListNode();

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return iterator(l1, l2, 0);
    }

    private static ListNode iterator(ListNode l1, ListNode l2, int carry) {
        int num = (l1.val + l2.val + carry);
        int value = num % 10;
        carry = (num >= 10) ? 1 : 0;
        if (l1.next == null && l2.next == null) {
            return new ListNode(value, (num >= 10) ? new ListNode(carry) : null);
        }
        ListNode node1 = (l1.next != null) ? l1.next : zeroNode;
        ListNode node2 = (l2.next != null) ? l2.next : zeroNode;
        return new ListNode(value, iterator(node1, node2, carry));
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
}

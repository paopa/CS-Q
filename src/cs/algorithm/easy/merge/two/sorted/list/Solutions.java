package cs.algorithm.easy.merge.two.sorted.list;

/**
 * 21. Merge Two Sorted Lists
 * Easy
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public abstract class Solutions {

    public abstract ListNode mergeTwoLists(ListNode l1, ListNode l2);

    public static Solutions factory(String version) {
        switch (version) {
            case "1":
            default:
                return new Solution1();
            case "2":
                return new Solution2();
        }
    }

    static final class Solution2 extends Solutions {

        @Override
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //todo
            return null;
        }
    }

    static final class Solution1 extends Solutions {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            return extract(new ListNode(), l1, l2);
        }

        private ListNode extract(ListNode tail, ListNode l1, ListNode l2) {
            if (null == l1 && null == l2) {
                return null;
            }
            if (null == l1) {
                tail.val = l2.val;
                if (l2.next != null) {
                    tail.next = new ListNode();
                    extract(tail.next, null, l2.next);
                }
            } else if (null == l2) {
                tail.val = l1.val;
                if (l1.next != null) {
                    tail.next = new ListNode();
                    extract(tail.next, l1.next, null);
                }
            } else if (l2.val >= l1.val) {
                tail.val = l1.val;
                tail.next = new ListNode();
                extract(tail.next, l1.next, l2);
            } else {
                tail.val = l2.val;
                tail.next = new ListNode();
                extract(tail.next, l1, l2.next);
            }
            return tail;
        }
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

class Test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode l1 = null;
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        ListNode l2 = null;
        System.out.println(Solutions.factory("1").mergeTwoLists(l1, l2));
    }
}

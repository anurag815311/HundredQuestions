class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class leetcode141 {

    // Floyd's Cycle Detection Algorithm
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move 1 step
            fast = fast.next.next; // move 2 steps

            if (slow == fast) { // collision → cycle
                return true;
            }
        }

        return false; // reached null → no cycle
    }

    // Helper: create linked list from array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int n : nums) {
            curr.next = new ListNode(n);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: add cycle (connect last node to position 'pos')
    public static void addCycle(ListNode head, int pos) {
        if (pos == -1)
            return; // no cycle

        ListNode tail = head;
        ListNode cycleNode = null;
        int index = 0;

        while (tail.next != null) {
            if (index == pos)
                cycleNode = tail;
            tail = tail.next;
            index++;
        }
        // connect tail to cycleNode
        tail.next = cycleNode;
    }

    public static void main(String[] args) {
        // Example 1: List with cycle
        int[] nums1 = { 3, 2, 0, -4 };
        ListNode head1 = createList(nums1);
        addCycle(head1, 1); // cycle at index 1 (node with val=2)

        System.out.println("Has Cycle (Example 1): " + hasCycle(head1)); // true

        // Example 2: List without cycle
        int[] nums2 = { 1, 2 };
        ListNode head2 = createList(nums2);
        addCycle(head2, -1); // no cycle

        System.out.println("Has Cycle (Example 2): " + hasCycle(head2)); // false
    }
}

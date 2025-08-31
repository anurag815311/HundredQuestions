// Definition for singly-linked list.
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

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // 1. Find middle (slow will stop at mid)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalf = reverse(slow);

        // 3. Compare first half & reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        while (p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Helper function to reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

public class leetcode234 {
    // Helper: create linked list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: Palindrome
        int[] arr1 = { 1, 2, 2, 1 };
        ListNode list1 = createList(arr1);
        System.out.print("List 1: ");
        printList(list1);
        System.out.println("Is Palindrome? " + sol.isPalindrome(list1));

        // Example 2: Not a palindrome
        int[] arr2 = { 1, 2 };
        ListNode list2 = createList(arr2);
        System.out.print("List 2: ");
        printList(list2);
        System.out.println("Is Palindrome? " + sol.isPalindrome(list2));
    }
}

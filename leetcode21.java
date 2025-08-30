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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node banate hain (head track karne ke liye)
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Jab tak dono lists non-empty hain
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Agar koi list bachi ho to attach kar do
        if (list1 != null)
            current.next = list1;
        if (list2 != null)
            current.next = list2;

        return dummy.next; // actual head
    }
}

// Test the implementation
public class leetcode21 {
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
        // Example: list1 = [1,2,4], list2 = [1,3,4]
        int[] arr1 = { 1, 2, 4, 5 };
        int[] arr2 = { 1, 3, 4, 6 };

        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(list1, list2);

        // Print result
        System.out.print("Merged List: ");
        printList(merged);
    }
}

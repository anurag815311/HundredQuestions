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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    // Divide & Conquer function
    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left]; // single list return
        int mid = left + (right - left) / 2;

        // divide
        ListNode l1 = mergeSort(lists, left, mid);
        ListNode l2 = mergeSort(lists, mid + 1, right);

        // merge 2 sorted lists
        return mergeTwoLists(l1, l2);
    }

    // Merge Two Sorted Lists (same as LeetCode 21)
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

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

        if (list1 != null)
            current.next = list1;
        if (list2 != null)
            current.next = list2;

        return dummy.next;
    }
}

public class leetcode23 {
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
        // Example input:
        // lists = [ [1,4,5], [1,3,4], [2,6] ]
        int[] arr1 = { 1, 4, 5 };
        int[] arr2 = { 1, 3, 4 };
        int[] arr3 = { 2, 6 };

        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);
        ListNode list3 = createList(arr3);

        ListNode[] lists = { list1, list2, list3 };

        Solution sol = new Solution();
        ListNode merged = sol.mergeKLists(lists);

        // Print merged result
        System.out.print("Merged List: ");
        printList(merged);
    }
}

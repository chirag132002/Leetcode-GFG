/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
        public ListNode deleteMiddle(ListNode head) {
        // If the list is empty or has only one node, return null
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To keep track of the node before the middle node

        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Remove the middle node by skipping it
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }
    }
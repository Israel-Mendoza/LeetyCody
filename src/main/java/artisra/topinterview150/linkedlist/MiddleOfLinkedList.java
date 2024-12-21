package artisra.topinterview150.linkedlist;

/**
 * This class provides a solution for finding the middle node of a singly linked list.
 * For lists with an even number of nodes, it returns the second of the two middle nodes.
 * @see <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Problem Description on LeetCode</a>
 */
public class MiddleOfLinkedList {

    /**
     * Finds the middle node of a given singly linked list.
     * Uses the "tortoise and hare" algorithm (two-pointer technique) to find the middle efficiently.
     *
     * @param head The head node of the linked list. Can be null.
     * @return The middle node of the list. If the list has an even number of nodes,
     *         returns the second of the two middle nodes. Returns null if the input list is empty.
     *
     * @example For list: 1 -> 2 -> 3 -> 4 -> 5, returns the node with value 3.
     * @example For list: 1 -> 2 -> 3 -> 4 -> 5 -> 6, returns the node with value 4.
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


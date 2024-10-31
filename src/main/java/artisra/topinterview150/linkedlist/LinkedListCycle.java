package artisra.topinterview150.linkedlist;

/**
 * This class provides a method to detect cycles in a linked list.
 * It utilizes Floyd's Cycle-Finding Algorithm for efficient detection.
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/solutions/5988514/java-kotlin-time-o-n-space-o-1">My Solution on LeetCode</a>
 */
public class LinkedListCycle {
    /**
     * Determines if a cycle exists in the given linked list.
     * <p>
     * The algorithm employs two pointers, `slow` and `fast`.
     * The `slow` pointer moves one node at a time, while the `fast` pointer moves two nodes at a time.
     * If a cycle exists, the two pointers will eventually meet at a node within the cycle.
     *
     * @param head The head node of the linked list to be checked.
     * @return `true` if a cycle is found, `false` otherwise.
     *
     * <p>
     * Time complexity: O(N), where N is the number of nodes in the linked list.
     * Space complexity: O(1), as it uses constant extra space for the two pointers.
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            for (int i = 0; i < 2; i++) {
                if (fast != null) fast = fast.next;
            }
            if (slow.next != null) slow = slow.next;

            if (slow == fast) return true;
        }
        return false;
    }
}

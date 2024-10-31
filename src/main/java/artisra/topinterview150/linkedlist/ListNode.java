package artisra.topinterview150.linkedlist;

/**
 * Represents a node in a singly linked list.
 * <p>
 * Each node contains an integer value and a reference to the next node in the list.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode(value=" + val + ",next=" + next + ")";
    }
}

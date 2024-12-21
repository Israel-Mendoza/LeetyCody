package artisra.topinterview150.linkedlist;

/**
 * Represents a node in a singly linked list.
 * <p>
 * Each node contains an integer value and a reference to the next node in the list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode(value=" + val + ",next=" + next + ")";
    }
}

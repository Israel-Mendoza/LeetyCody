package dev.artisra.topinterview150.linkedlist

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

class RemoveNthNodeFromEnd {

    class ListNode(var value: Int) {
        var next: ListNode? = null
        override fun toString(): String {
            return "ListNode(value=$value,next=$next)"
        }
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        // Using three temporary nodes:
        var fast = head
        var prev = head
        var current = head

        // Moving the fast pointer first, to gain the N difference to the end
        repeat(n) {
            fast = fast?.next
        }

        // Advancing the three nodes at the same pace:
        while (fast != null) {
            prev = current
            current = current?.next
            fast = fast?.next
        }

        // If we haven't move, it means we need to remove the head:
        if (current === head) {
            return head?.next
        }

        // Removing the item
        prev?.next = current?.next
        current?.next = null
        return head
    }
}

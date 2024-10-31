package dev.artisra.topinterview150.linkedlist

/**
 * This class provides a method to detect cycles in a linked list.
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/solutions/5988514/java-kotlin-time-o-n-space-o-1">My Solution on LeetCode</a>
 */
class LinkedListCycle {
    /**
     * Detects if a cycle exists in a linked list.
     *
     * @param head The head node of the linked list.
     * @return `true` if a cycle is found, `false` otherwise.
     */
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast != null) {
            repeat(2) {
                fast = fast?.next
            }
            slow = slow?.next
            if (slow === fast) return true
        }

        return false
    }
}

/**
 * Represents a node in a linked list.
 */
data class ListNode(var value: Int) {
    var next: ListNode? = null
}

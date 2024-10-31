package dev.artisra.topinterview150.linkedlist

/**
 * Represents a node in a linked list.
 */
class ListNode(var value: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(value=$value,next=$next)"
    }
}
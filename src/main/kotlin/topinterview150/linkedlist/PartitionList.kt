package dev.artisra.topinterview150.linkedlist

/// https://leetcode.com/problems/partition-list/description/

class PartitionList {

    inner class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun partition(head: ListNode?, x: Int): ListNode? {

        if (head == null) return null

        var primaryPartition: ListNode? = null
        var primaryPointer: ListNode? = null
        var secondaryPartition: ListNode? = null
        var secondaryPointer: ListNode? = null
        var tempNode = head

        while (tempNode != null) {
            if (tempNode.value < x) {
                if (primaryPartition == null) {
                    primaryPartition = tempNode
                    primaryPointer = primaryPartition
                } else {
                    primaryPointer!!.next = tempNode
                    primaryPointer = tempNode
                }


            } else {
                if (secondaryPartition == null) {
                    secondaryPartition = tempNode
                    secondaryPointer = secondaryPartition
                } else {
                    secondaryPointer!!.next = tempNode
                    secondaryPointer = tempNode
                }

            }

            tempNode = tempNode.next
        }
        if (primaryPointer != null) {
            primaryPointer.next = secondaryPartition
        }
        if (secondaryPointer != null) secondaryPointer.next = null
        return primaryPartition ?: secondaryPartition

    }
}
package dev.artisra.topinterview150.arraystring

// https://leetcode.com/problems/h-index/solutions/

class HIndex {

    /**
     * Calculates the h-index of a scientist based on the number of citations of their published papers.
     * The h-index is defined as the maximum number `h` such that the scientist has `h` papers with at least `h` citations each.
     *
     * This function uses a brute-force approach.
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param citations an integer array representing the number of citations for each of the scientist's published papers
     * @return the h-index of the scientist
     */
    fun hIndex(citations: IntArray): Int {
        for (i in citations.size downTo 1) {
            val iCitationsCount = citations.count { it >= i }
            if (iCitationsCount >= i ) return i
        }
        return 0
    }

    /**
     * Calculates the h-index of a scientist based on the number of citations of their published papers.
     * The h-index is defined as the maximum number `h` such that the scientist has `h` papers with at least `h` citations each.
     *
     * This approach using sorting.
     *
     * Time complexity: O(n log n)
     * Space complexity: O(1)
     *
     * @param citations an integer array representing the number of citations for each of the scientist's published papers
     * @return the h-index of the scientist
     */
    fun hIndexSorted(citations: IntArray): Int {
        citations.sortDescending()
        var h = 0
        for (i in citations.indices) {
            if (citations[i] > i) h++
        }
        return h
    }
}
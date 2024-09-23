package dev.artisra.topinterview150.arraystring

class RotateArray {
    fun rotate(nums: IntArray, k: Int) {

        // Arrays with a single elements or empty arrays won't change.
        if (nums.isEmpty() || nums.size == 1) return

        repeat(k) {
            // Grabbing the last item, to add it to the start of the array.
            val poppedItem = nums.last()
            // Moving all of the items in the array one step rightward.
            for (i in nums.size - 2 downTo 0) {
                nums[i + 1] = nums[i]
            }
            // Recovering the last item:
            nums[0] = poppedItem
        }
    }
}
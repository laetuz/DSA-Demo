package id.neotica.grokking

class Grokking {
    fun runBs1() {
        val myList = listOf(1, 3, 5, 6, 9)

        println(binarySearch(myList, 3))
        println(binarySearch(myList, -1))
        println(binarySearch(myList, 1))
        // 128 -> 64 -> 32 -> 16 -> 8 -> 4 -> 2 = 6
        // 256 = 7
    }
    fun binarySearch(arr: List<Int>, item: Int): Int? {
        var low = 0 // low and high keep track of which part of list you'll search in.
        var high = arr.size -1

        while(low <= high) { // while you haven't narrowed it down to one element
            val mid = low + high // check the middle element (divided by 2)
            val guess = arr[mid]
            if (guess == item) { // found the item.
                return mid
            } else if (guess > item) { // the guess was too high.
                high = mid - 1
            } else { // the guess was too low.
                low = mid + 1
            }
        }
        return null // the item doesn't exist.
    }
}
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

    fun runSs1() {
        println(selectionSort(arrayListOf(5,3,6,2, 2, 9)))
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

    fun findsSmallest(arr: MutableList<Int>): Int { // selection sort
        var smallest = arr[0]
        var smallestIndex = 0

        for (i in 1 until arr.size) {
            if (arr[i] < smallest) {
                smallest = arr[i]
                smallestIndex = i
            }
        }

        return smallestIndex
    }

    fun selectionSort(arr: ArrayList<Int>): List<Int> {
        val newArray = mutableListOf<Int>() //arrayOf(0)
        val copiedArray = arr.toMutableList()

        for (i in copiedArray.indices) {
            val smallest = findsSmallest(copiedArray)
            newArray.add(copiedArray.removeAt(smallest))
        }
        return newArray
    }

    fun factorial(x: Int): Long = if (x == 1) 1 else x * factorial(x -1)

    fun quickSort(array: List<Int>): List<Int> {
        val test = listOf(1,2,3,4).sortedBy { it == 2 }
        if (array.size < 2) {
            return array
        } else {
            val pivot = array[0]
            val less = array.drop(1).filter { it <= pivot }
            val greater = array.drop(1).filter { it > pivot }

            return quickSort(less) + pivot + quickSort(greater)
        }
    }

    fun maps() {
        val book = mutableMapOf<String, String>()

        book["doofus"] = "hell yeah"
        book["lotr"] = "Lord of the rings"
        book.remove("lotr")
        book.clear()
        book["lol"] = "Lord or the fireflies"

        println(book["doofus"])
        println(book)
    }


}
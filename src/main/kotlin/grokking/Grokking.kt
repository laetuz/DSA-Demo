package id.neotica.grokking

import id.neotica.queue.oday.Queue
import id.neotica.queue.oday.QueueImpl
import java.util.*
import java.util.Queue as javaQue

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

    fun graph() {
        val graph = mutableMapOf<String, List<String>>()
        graph["you"] = listOf("alice", "bob", "claire")
        graph["bob"] = listOf("anuj", "peggy")
        graph["alice"] = listOf("peggy")
        graph["claire"] = listOf("thom", "jhonny")
        graph["peggy"] = listOf()
        graph["thom"] = listOf()
        graph["jhonny"] = listOf()

        val searchQue: java.util.Queue<List<String>> =LinkedList()// listOf("")  //QueueImpl<List<String>?>()
        searchQue.poll()
        searchQue.add(graph["you"])

//        println( bfSearch(graph, "you"))
        val bfs = bfSearch(graph, "you")
        if (bfs) println("mango seller found.") else println("No mango seller found.")
    }

    fun bfSearch(graph: Map<String, List<String>>, start: String): Boolean {
        val searchQueue: javaQue<String> = LinkedList()

        searchQueue.addAll(graph[start] ?: emptyList())

        val searched = mutableSetOf<String>()

        fun personIsSeller(name: String): Boolean = name.lastOrNull() == 'j'

        while (searchQueue.isNotEmpty()) {
            val person = searchQueue.poll()
            if (personIsSeller(person)) {
                println("$person is a mango seller")
                return true
            } else {
                searchQueue.addAll(graph[person] ?: emptyList())

                searched.add(person)
            }
//            if (person !in  searched) {
//
//            }

        }
        return false
    }

    fun dijkstraRaw() {
        val graph = mutableMapOf<String, MutableMap<String, Int>>()
        graph["start"] = mutableMapOf(
            "a" to 6,
            "b" to 2,
        )

        graph["a"] = mutableMapOf(
            "fin" to 1
        )
        graph["b"] = mutableMapOf(
            "a" to 3,
            "fin" to 5
        )
        graph["fin"] = mutableMapOf()

        println(graph["b"]/*?.get("a")*/)
    }

    fun dijkstraGraph(): Map<String, Map<String, Int>> = mapOf(
        "start" to mapOf("a" to 6, "b" to 2),
        "a" to mapOf("fin" to 1),
        "b" to mapOf("a" to 3, "fin" to 5),
        "fin" to emptyMap()
    )

    fun createGraph() {
        val infinity = Double.POSITIVE_INFINITY

        val graph = mutableMapOf(
            "start" to mutableMapOf("a" to 6.0, "b" to 2.0),
            "a" to mutableMapOf("fin" to 1.0),
            "b" to mutableMapOf("a" to 3.0, "fin" to 5.0),
            "fin" to mutableMapOf()
        )

        var age: List<Int>
        var current = 0
        var sortedAge = mutableListOf<Int>()
        age = listOf(9,8,6,3,1,2)
        age.sorted()
        sortedAge = age.takeLast(2).toMutableList()


        println("age = " + age)
        println("sortedAge = " + sortedAge)

        println("graph = $graph")
        println("keys = " + graph.keys)
        println("graph start = " + graph["start"])

        // 🔹 Automatically initialize costs from graph["start"]
        val costs = mutableMapOf<String, Double>().apply {
            putAll(graph["start"] ?: emptyMap()) // Copy initial neighbors from start
            put("fin", infinity) // Ensure "fin" has infinity if it's not a direct neighbor
        }
        println("costs graph = " + costs)

        // 🔹 Automatically initialize parents from graph["start"]
        val parents = mutableMapOf<String, String?>().apply {
            graph["start"]?.keys?.forEach { put(it, "start") }
        }
        println("parents graph = " + parents)

        val processed = mutableSetOf("")

        var node = findLowestCostNode(costs, processed)

        while ( node!= null) {
            val cost = costs[node]!!
            val neighbors = graph[node] ?: emptyMap()

            for ((neighbor, weight) in neighbors) {
                val newCost = cost + weight
                if (newCost < (costs[neighbor]?: infinity)) {
                    costs[neighbor] = newCost
                    parents[neighbor] = node
                }
            }
            processed.add(node)
            node = findLowestCostNode(costs, processed)
        }
        println("Final costs: $costs")
        println("Final parents: $parents")
    }

    fun findLowestCostNode2(costs: Map<String, Double>, processed: Set<String>): String? {
        var lowestCost = Double.POSITIVE_INFINITY
        var lowestCostNode: String? = null

        for ((node, cost) in costs) {
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost
                lowestCostNode = node
            }
        }
        return lowestCostNode
    }

    fun findLowestCostNode(costs: Map<String, Double>, processed: Set<String>): String? {
        return costs
            .filterKeys { it !in processed }
            .minByOrNull { it.value }
            ?.key
    }


    fun dijkstra() {


        println(createGraph())
    }

}
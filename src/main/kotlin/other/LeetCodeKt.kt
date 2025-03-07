package id.neotica.other

class LeetCodeKt {
    fun hasDuplicate1(nums: IntArray): Boolean {
        nums.sort()
        val num = nums.toList()
        var newList = arrayListOf<Int>()
        var newNum = 0
        for (i in nums){
            newList.add(i)
            if (i != newNum) {
                newNum = i
                if (newList.contains(newNum)) println("contain")
            } else return true
        }
    return false
    }

    fun hasDuplicateFunctional(nums: IntArray): Boolean = nums.toSet().size!= nums.size

    fun hasDuplicate(nums: IntArray): Boolean {
        val newList = mutableSetOf<Int>()
        for (num in nums) {
            if (!newList.add(num)) return true
        }
        return false
    }
}
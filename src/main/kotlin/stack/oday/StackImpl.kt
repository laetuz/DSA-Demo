package id.neotica.stack.oday

class StackImpl<T: Any>: Stack<T> {

    private var storage = arrayListOf<T>()

    override fun pop(): T? = storage.removeLastOrNull()


    override fun peek(): T? = storage.lastOrNull()


    override val count: Int
        get() = storage.size

    override fun push(element: T) {
        storage.add(element)
    }

}

fun String.validParentheses(): Boolean {
    val stack = StackImpl<Char>()

    for (char in this) {
        when (char) {
            '(' -> stack.push(char)
            ')' -> if (!stack.isEmpty) stack.pop()
        }
    }
    return stack.isEmpty
}
package id.neotica.queue.oday

class QueueImpl<T>: Queue<T> {
    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size
    override val isEmpty: Boolean
        get() = count == 0

    override fun peek(): T? {
        return storage.getOrNull(0)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else storage.removeAt(0)
    }

    override fun enqueue(element: T): Boolean {
        return storage.add(element)
    }
}
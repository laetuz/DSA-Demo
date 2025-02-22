package id.neotica.queue

import id.neotica.queue.oday.QueueImpl

fun queueDemo() {
    val que = QueueImpl<Int>()
    que.enqueue(element = 1)
    que.enqueue(element = 2)
    que.enqueue(element = 3)
    que.enqueue(element = 5)
    que.count
    que.peek()
    println(que.dequeue())
    println(que.peek())
}
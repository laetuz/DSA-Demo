package id.neotica.stack
import java.util.*

fun stackInJava() {

    val stack = Stack<String>()

    stack.push("Odin") //Bottom Stack
    stack.push("Thor")
    stack.push("Loki")
    stack.push("Freya")
    stack.push("Heimdall") //Top Stack

    printAllStack(stack)
    peekStack(stack)
    popStack(stack)
    printAllStack(stack)
    searchStack(stack, "Freya")
}

fun peekStack(stack: Stack<String>) = println("Top stack: ${stack.peek()}")
fun popStack(stack: Stack<String>) = println("Popped: ${stack.pop()}")
fun printAllStack(stack: Stack<String>) = println("Full stack: $stack")
fun searchStack(stack: Stack<String>, search: String) = println(stack.search(search))
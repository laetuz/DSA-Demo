package id.neotica.stack
import id.neotica.mainMenu
import id.neotica.prependNewLine
import java.util.*

fun stackInJava() {

    val stack = Stack<String>()

    do {
        println("Select option".prependNewLine())
        println("1. Peek Stack")
        println("2. Push Stack")
        println("3. Pop Stack ")
        println("4. Print All Stack")
        println("5. Search Stack")
        println("6. Back to Main Menu")
        println("7. Exit")
        print("Input: ".prependNewLine())
        val userInput = readln()

        when (userInput) {
            "1" -> {
                if (stack.isNotEmpty()) {
                    peekStack(stack)
                } else println("Stack is empty.")
            }
            "2" -> {
                print("Input: ")
                val input = readln()

                if (input.isNotEmpty()) {
                    stack.push(input)
                    println("Successfully added $input to the stack.")
                } else {
                    println("Please enter a value.")
                }
            }
            "3" -> {
                if (stack.isNotEmpty()) {
                    println()
                    popStack(stack)
                } else println("Stack is empty.")
            }
            "4" -> {
                println()
                printAllStack(stack)
            }
            "5" -> {
                val input = readln()
                if (input.isNotEmpty()) {
                    searchStack(stack = stack, search = input)
                } else println("Please enter a value.")

            }
            "6" -> mainMenu()
            "7" -> break
            else -> {
                println("There's no such option.".prependNewLine())
            }
        }
    } while (true)
}

fun stackInJavaDemo() {

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
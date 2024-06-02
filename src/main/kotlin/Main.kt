package id.neotica

import id.neotica.queue.queueDemo
import id.neotica.stack.stackDemo
import kotlinx.coroutines.*

fun main() {
    welcomeMessage()
}

fun welcomeMessage() {
    println("=======================================================")
    println("Welcome! To Data Structure and Algorithm Demo by Martin")
    println("=======================================================")
    println("Please press Enter.")
    do {
        val userInput = readln()
        if (userInput != "") {

            pleaseWait()

            CoroutineScope(Dispatchers.IO).launch {
                delay(2500)
                println("Invalid input. Please press Enter")
            }
        }
    } while (userInput != "")
    println("Thank you. You have the right input.")

    mainMenu()
}

fun mainMenu() {
    println("Select option")
    println("1. Stack Demo")
    println("2. Queue Demo")
    val userInput = readln()

    when (userInput.toIntOrNull()) {
        1 -> stackDemo()
        2 -> queueDemo()
    }
}

fun pleaseWait() = CoroutineScope(Dispatchers.IO).launch {
    print("Please wait")
    delay(500)
    print(".")
    delay(500)
    print(".")
    delay(500)
    println(".")
    delay(500)
}
package id.neotica

import id.neotica.grokking.Grokking
import id.neotica.other.discreteMath
import id.neotica.queue.queueDemo
import id.neotica.stack.stackDemo
import kotlinx.coroutines.*
import LeetCode
import id.neotica.other.LeetCodeKt

fun main() {
    val grok = Grokking()
    val leetCode = LeetCode()
//    Grokking().runBs1()
//    Grokking().runSs1()
//    println(Grokking().factorial(16))
//    println(Grokking().quickSort(listOf(10, 5, 2, 3, 11, 4, 2)))
//    println(Grokking().maps())
//    println(grok.graph())
//    grok.dijkstra()
    var intArr = intArrayOf(1,3,2,4,4)
    leetCode.hasDuplicate(intArr)
    println("bool: " + LeetCodeKt().hasDuplicate(intArr))
    println("boolfunc: " + LeetCodeKt().hasDuplicateFunctional(intArr))
//    leetCode.printLol()
//    welcomeMessage()
}

fun welcomeMessage() {
    println("=======================================================")
    println("Welcome! To Data Structure and Algorithm Demo by Martin")
    println("=======================================================")
    println("Please press Enter.")
    inputCheck("")
    mainMenu()
}

fun mainMenu() {
    println("Main Menu")
    println("1. Stack Demo")
    println("2. Queue Demo")
    println("3. Other")
    print("Input: ".prependNewLine())
    val userInput = readln()

    when (userInput.toIntOrNull()) {
        1 -> stackDemo()
        2 -> queueDemo()
        3 -> discreteMath()
        else -> {
            println("There's no such option.")

            mainMenu()
        }
    }
}

fun inputCheck(input: Any) {
    do {
        print("Input: ".prependNewLine())
        val userInput = readln()
        userInput.split(" ").mapNotNull { it.toIntOrNull() }
        if (userInput != input) {

            pleaseWait()

            CoroutineScope(Dispatchers.IO).launch {
                delay(2500)
                if (input != "") {
                    println("Invalid input. Please press $input")
                } else {
                    println("Invalid input. Please press Enter")
                }
            }
        }
    } while (userInput != input)
    println("Thank you. You have the right input.".prependNewLine())
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

fun String.prependNewLine(): String {
    return "\n$this" // Add newline followed by the original string
}
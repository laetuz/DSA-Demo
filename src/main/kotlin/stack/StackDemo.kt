package id.neotica.stack

import id.neotica.prependNewLine

fun stackDemo() {
/**
 * Stack = LIFO data structure. Last-In, First-Out.
 * stores object into a sort of "Vertical Tower"
 * push() to add to the top
 * pop() to remove from the top
 *
 * Uses of stack
 * 1. undo/redo features in text editors
 * 2. moving back/forward through browser history
 * 3. backtracking algorithm (maze, file directories)
 * 4. calling functions (call stack)
 *
 * reference: Bro Code "Learn data structure in 10 minutes 📚
 * link: https://www.youtube.com/watch?v=KInG04mAjO0
**/

    println("Welcome to Stack Demo! Select option!".prependNewLine())
    println("1. Show Demo")
    println("2. Play Demo")
    print("Input: ".prependNewLine())
    val userInput = readln()
    when (userInput.toIntOrNull()) {
        1 -> stackInJavaDemo()
        2 -> stackInJava()
        else -> {
            println("There's no such option.")

            stackDemo()
        }
    }
}
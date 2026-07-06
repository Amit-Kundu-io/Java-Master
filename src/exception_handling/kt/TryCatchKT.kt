package exception_handling.kt

fun main() {
    try {
        val i = 10 / 0
    }
    catch (e: Exception) {
        println("Exception")
        e.printStackTrace()
    }
    println("Process complete")
}



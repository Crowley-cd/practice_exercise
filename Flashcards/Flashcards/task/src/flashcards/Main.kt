package flashcards

import java.io.File

var STATUS_OF_PROGRAMM = true
val cards = Cards()
fun main() {

    while (STATUS_OF_PROGRAMM == true) {
    mainMenu(cards)

    }
}

fun mainMenu(cards: Cards) {
    println("Input the action (add, remove, import, export, ask, exit):")
    var select = readln()
    when (select) {
        "add" -> cards.addCardFromText()
        "remove" -> cards.remove()
        "import" -> cards.addCardsFromFile()
        "export" -> cards.export()
        "ask" -> cards.Check()
        "exit" -> exit()

        else -> {
            println("Try again")
            mainMenu(cards)
        }
    }
}


fun exit() {
    println("Bye bye!")
    STATUS_OF_PROGRAMM = false
}






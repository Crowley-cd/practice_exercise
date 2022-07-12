package flashcards

import java.io.FileNotFoundException
import java.lang.Exception
import kotlin.random.Random
import java.io.File as File

class Cards {
    val cards = mutableListOf<Card>()
    fun addCardFromText() {
        println("The card:")
        var addTerm = readln()

        while (cards.any { it.term == addTerm || it.def == addTerm }) {
            println("The card \"$addTerm\" already exists.")
            return
        }

        println("The definition of the card:")
        var addDef = readln()

        while (cards.any { it.def == addDef || cards.any { it.term == addDef } }) {
            println("The definition \"${addDef}\" already exists. Try again:")
//            addDef = readln()
            return
        }
        this.cards.add(Card(addTerm, addDef))
        println("The pair (\"$addTerm\":\"$addDef\") has been added.")
    }

    fun Check() {
        println("How many times to ask?")
        var numQuestions = readln().toInt()

        for (i in 1..numQuestions) {
            var randomNumber = Random.nextInt(cards.size) // + 1
            println("Print the definition of \"${cards[randomNumber].term}\":")
            var answer = readln()
            if (answer == cards[randomNumber].def) {
                println("Correct!")
            } else if (cards.any { answer == it.def }) {
                println(
                    "Wrong. The right answer is \"${cards[randomNumber].def}\", but your definition " +
                            "is correct for \"${
                                (cards.filter { answer == it.def })
                                    .first()
                                    .term
                            }\"."
                )
            } else {
                println("Wrong. The right answer is \"${cards[randomNumber].def}\".")
            }
        }

    }

    fun addCardsFromFile() { // need add overwrite repeated case. priority - Imported cards.
        println("File name:")
        val importFile = readln()
        var size = 0
        try {
            val readFile = File(importFile).readLines()
            for (line in readFile) {
                if (":" in line) { // defence from empty or incorrect lines
                    if (cards.any { it.term == sepInputData(line).term ||
                                    it.term == sepInputData(line).def ||
                                    it.def == sepInputData(line).def ||
                                    it.def == sepInputData(line).term }) {
                        cards -= cards.filter {it.term in line }
                        size -= 1
                    }
                    if (!cards.any { sepInputData(line).def in it.def ||
                    sepInputData(line).def in it.term || sepInputData(line).term in it.term
                                || sepInputData(line).term in it.def
                    }) { // defence from repeat
                        cards.add(sepInputData(line))
                        size++
                    }
                }
            }
            println("${size} cards have been loaded.")
        } catch (e: NoSuchFileException){
        println("File not found.")
    } catch (e: FileNotFoundException) {
        println("File not found.")
    }
}

    fun remove() {
        println("Which card?")
        val removedCard = readln()
        if (cards.any { removedCard == it.def || removedCard == it.term }) {
            cards -= cards.filter { it.def == removedCard || it.term == removedCard }
            println("The card has been removed.")
        } else {
            println("Can't remove \"$removedCard\": there is no such card.")
        }
    }

    fun export(){
        println("File name:")
        val nameOfFile = readln()
        val newFile = File(nameOfFile)
        for (i in 0..cards.size - 1)
        newFile.appendText("${cards[i].term}:${cards[i].def}\n")
        println("${cards.size} cards have been saved.")
    }

    fun sepInputData(input: String):Card {
        var (first,second) = input.split(":")
        return Card(first, second)
    }
}
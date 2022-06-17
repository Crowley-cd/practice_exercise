/* Create function which take string of letters as input and give restructure string as output */



fun countLetter(_inputString: String) {
    val inputString = _inputString
    var outputString = ""
    val resultList = inputString.toList().groupingBy { it }.eachCount()
    for (i in 0..resultList.size -1) {
        outputString += resultList.keys.toList()[i]
        outputString += resultList.values.toList()[i]
    }
    println(outputString)
}


fun main() {
    countLetter(readln().toUpperCase())
}

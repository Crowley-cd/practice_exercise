fun main() {
//    val massive1: List<String> = readln().split(" ")
//    val massive2: List<String> = readln().split(" ")
    var massive1 = listOf(1,2,3,2,0, 2 ,5, 3,3,4)
    var massive2 = listOf(5, 1, 2, 7 ,3, 0, 8,  2,2)
    var result = listOf<Int>()
//                        for (i in massive1) {
//                                if (i in massive1 && i in massive2) {    // solution 1 (FOR loop)
//                                    result += i
//                                    massive1 -= i
//                                    massive2 -= i
//                                }
//                        }



    println(result)
    println(getRepited(massive1, massive2))
}

fun getRepited(a1: List<Int>, a2: List<Int>): MutableList<Int> {
    a2.toHashSet()
    a1.toHashSet()
    var result = mutableListOf<Int>()
    for (el in a1) {
        if (el in a2) {
            result += el
            a2 -= el
        }
    }
    return result
}
package parking

object Parking {
     val spotParkingList = mutableListOf<Spot>()


    fun create(numberOfSpots: Int) {
        if (spotParkingList.isNotEmpty()) {
            spotParkingList.clear()
        }
        for (i in 1..numberOfSpots) {
            spotParkingList += Spot(spotNumber = i)
        }
        println("Created a parking lot with $numberOfSpots spots.")
        mainMenu()
    }

    fun status() {
        if (!spotParkingList.any { it.number != null })
            println("Parking lot is empty.")
        else {
        spotParkingList
            .filter { it.number != null }
            .forEach{ println("${it.spotNumber} ${it.number} ${it.color}")}
        }

        mainMenu()
    }

    fun isEmpty(spot: Spot): Boolean = spot.number == null && spot.color == null

    fun park(spot: Spot, _number: String?,_color: String?) {
        if (isEmpty(spot)) {
            spot.number = _number
            spot.color = _color
            println("${spot.color} car parked in spot ${spot.spotNumber}.")
        }

        mainMenu()
    }

    fun leave(spot: Spot) {
        if (spot.number == null && spot.color == null)
            println("There is no car in spot ${spot.spotNumber}.")
        else {
            spot.number = null
            spot.color = null
            println("Spot ${spot.spotNumber} is free.")
        }

        mainMenu()
    }

    fun regNumsByColor(color: String) {
        val result = spotParkingList.filter { it.color?.uppercase() == color.uppercase() }
        if (result.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(result.joinToString { it.number.toString() })
        }
        mainMenu()
    }


    fun spotByColor(color: String){
        val result = spotParkingList.filter { it.color?.uppercase() == color.uppercase() }
        if (result.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(result.joinToString { it.spotNumber.toString() })
        }
        mainMenu()
    }

    fun spotByRegNum(number: String){
        val result = spotParkingList.filter { it.number == number }
        if (result.isEmpty()) {
            println("No cars with registration number $number were found.")
        } else {
            println(result.joinToString { it.spotNumber.toString() })
        }
        mainMenu()
    }

    data class Spot(val spotNumber: Int, var number: String? = null, var color: String? = null)
}


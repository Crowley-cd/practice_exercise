package parking

import kotlin.system.exitProcess
val parking = Parking
fun main() {

    mainMenu()
}
    fun mainMenu() {
    val command = readln()
    val doing = command.split(" ").first()
    when (doing) {
        "create" -> {
            val (doing, number) = command.split(" ")
            parking.create(number.toInt())
        }
        "park" -> {
            val (doing, number, color) = command.split(" ")
            if (parking.spotParkingList.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                mainMenu()
            } else {
                for (spot in parking.spotParkingList) {
                    if (!parking.spotParkingList.any { parking.isEmpty(it) }) {
                        println("Sorry, the parking lot is full.")
                        mainMenu()
                    }
                    if (parking.isEmpty(spot))
                        parking.park(spot, number, color)
                }
            }
        }

        "leave" -> {
            if (parking.spotParkingList.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                mainMenu()
            }
            val (doing, number) = command.split(" ")
            parking.leave(parking.spotParkingList[number.toInt() - 1])
        }

        "status" -> {
            if (parking.spotParkingList.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                mainMenu()
                }
            parking.status()
        }

        "exit" -> exitProcess(0)

        "reg_by_color" -> {
            if (parking.spotParkingList.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                mainMenu()
            }
            val (doing, color) = command.split(" ")
            parking.regNumsByColor(color)
        }

        "spot_by_color" -> {
            if (parking.spotParkingList.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                mainMenu()
            }
            val (doing, color) = command.split(" ")
            parking.spotByColor(color)
        }

        "spot_by_reg" -> {
            if (parking.spotParkingList.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                mainMenu()
            }
            val (doing, number) = command.split(" ")
            parking.spotByRegNum(number)
        }
        else -> mainMenu()
    }

}


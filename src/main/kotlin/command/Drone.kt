package command

import command.Direction.*

class Drone {
    var x = 0
    var y = 0
    var direction: Direction = EAST
}

enum class Direction {
    EAST, WEST, NORTH, SOUTH
}
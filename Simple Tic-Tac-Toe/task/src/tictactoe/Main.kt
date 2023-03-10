package tictactoe

var whoWin = 'a'
var win = false
var field = mutableListOf(mutableListOf<Char>())
var turnXO = 1

fun main() {

     field = mutableListOf(mutableListOf(' ', ' ', ' '),
                           mutableListOf(' ', ' ', ' '),
                           mutableListOf(' ', ' ', ' ')
    )

    printField()

    while (!fullTable() && !threeWin()) {

        correctInput(turnXO)
        printField()
        turnXO++
    }


    if (threeWin()) println("$whoWin wins")
    if (fullTable() && !threeWin()) println("Draw")

}

fun printField() {
    println("---------")
    for (i in 0..2) println("| ${field[i].joinToString(" ")} |")
    println("---------")
}


fun correctInput(turn :Int) {
    var inputOk = false

    while (inputOk == false) {
        val  x = readln().split(" ")

        try {
            val xInput = x[0].toInt()
            val yInput = x[1].toInt()

            when {
                xInput !in 1..3 || yInput !in 1..3 -> println("Coordinates should be from 1 to 3!")
                field[xInput-1][yInput-1]  == 'X' || field[xInput-1][yInput-1]  == 'O' -> println("This cell is occupied! Choose another one!")
                field[xInput-1][yInput-1]  == ' ' || field[xInput-1][yInput-1]  == '_' -> {
                    if (turn % 2 != 0) field[xInput-1][yInput-1] = 'X' else field[xInput-1][yInput-1] = 'O'
                    inputOk = true
                }
            }

        } catch (e : Exception) {
            println("You should enter numbers!")
        }
    }
}

fun fullTable() : Boolean {
    var a = true
    for (i in 0..2)
        for (j in 0..2){
            if (field[i][j] == '_' || field[i][j] == ' ') {
                a = false
            }
    }
    return a
}

fun threeWin() : Boolean {
    if (field[0][0]==field[0][1] && field[0][0]==field[0][2]) {
        if (field[0][0] != ' ' && field[0][0] != '_') {
            win = true
            whoWin = field[0][0]
        }

    }
    if (field[1][0]==field[1][1] && field[1][0]==field[1][2]) {
        if (field[1][0] != ' ' && field[1][0] != '_') {
            win = true
            whoWin = field[1][0]
        }
    }
    if (field[2][0]==field[2][1] && field[2][0]==field[2][2]) {
        if (field[2][0] != ' ' && field[2][0] != '_') {
            win = true
            whoWin = field[2][0]
        }
    }
    if (field[0][0]==field[1][0] && field[0][0]==field[2][0]) {
        if (field[0][0] != ' ' && field[0][0] != '_') {
            win = true
            whoWin = field[0][0]
        }
    }
    if (field[0][1]==field[1][1] && field[0][1]==field[2][1]) {
        if (field[0][1] != ' ' && field[0][1] != '_') {
            win = true
            whoWin = field[0][1]
        }
    }
    if (field[0][2]==field[1][2] && field[0][2]==field[2][2]) {
        if (field[0][2] != ' ' && field[0][2] != '_') {
            win = true
            whoWin = field[0][2]
        }
    }
    if (field[0][0]==field[1][1] && field[0][0]==field[2][2]) {
        if (field[0][0] != ' ' && field[0][0] != '_') {
            win = true
            whoWin = field[0][0]
        }
    }
    if (field[0][2]==field[1][1] && field[0][2]==field[2][0]) {
        if (field[0][2] != ' ' && field[0][2] != '_') {
            win = true
            whoWin = field[0][2]
        }
    }
    return win

}



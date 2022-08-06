package collections

import java.util.Scanner

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var a = 0
    var b = 1

//TODO: Complete os espaços em branco com uma possível solução para o desafio

    for (i in 1..(n -1)) {
        print("${a}  ")

        val sum = a+b
            a = b
                b = sum
    }
    println("$a  ")
}
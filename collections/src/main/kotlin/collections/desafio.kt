package collections

import java.util.Scanner

fun main() {

//TODO: Complete os espaços em branco com uma possível solução para o desafio

    val notas: IntArray = intArrayOf(100, 50, 20, 10, 5, 2, 1)
    var valor = readLine()!!.toInt()

    println(  valor    )

    for (i in 0..(notas.size - 1)) {
        if (valor >= notas[i]) {

            println("${  valor/notas[i]     } nota(s) de R$ " + notas[i] + ",00")
        } else {
            println("0 nota(s) de R$ " + notas[i] + ",00")
        }
        valor = valor % notas[i]
    }
}
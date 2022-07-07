package collections

fun main() {
    val salarios = DoubleArray(3)
    salarios[0]= 1000.0
    salarios[1]= 3000.0
    salarios[2]= 500.0

    for(salario in salarios){
        println(salario)
    }

    salarios.sort()
    salarios.reverse()
    salarios[0]=10000.0
    println("-------------------------------------")
    salarios.forEachIndexed { index, salario ->
        salarios[index] = salario * 1.1
    }

    salarios.forEach {
        println(it)
    }

    println("-------------------------------------")
    val salarios2 = doubleArrayOf(1500.0,7000.0,9000.0)

    salarios2.sort()
    salarios2.reverse()
    salarios2.forEach {
        println(it)
    }
}
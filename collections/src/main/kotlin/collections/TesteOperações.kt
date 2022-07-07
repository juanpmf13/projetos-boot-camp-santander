package collections

fun main() {
    val salarios = doubleArrayOf(1000.0,3000.0,900.0)

    for(salario in salarios){
        println(salario)
    }
    println("\n------------------------------------------------\n")


    println("Maior Salario: ${salarios.maxOrNull()}")
    println("Manor Salario> ${salarios.minOrNull()}")
    println("Média Salarial> ${salarios.average()}")

    val salariosMaiorque2500 = salarios.filter { it >2500.0 } // filter funcionaria em um objeto ? sim funcionaria

    println("\n------------------------------------------------\n")

    println("salarios maior que 2500: $salariosMaiorque2500")

    println("\n------------------------------------------------\n")

    println("quantidade de salarios entre 1000.0 e 5000.0 : ${salarios.count{it in  1000.0..5000.00}}")

    println("\n------------------------------------------------\n")

    println("existe salarios igual a 900.0 ? \n ${if(salarios.find { it == 900.0 }==900.0) "sim" else "não"}")

    println("\n------------------------------------------------\n")

    println("existe salarios igual a 900.0 ? \n ${if(salarios.any{it == 900.0}) "sim" else "não"}" )
}
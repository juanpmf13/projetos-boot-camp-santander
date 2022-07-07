package collections

fun main() {

    val idades = intArrayOf(10, 20, 21, 22, 30, 31, 40, 43, 50)
    val result = idades.filter { it>31 }
    println(result)
    val joao = Funcionario("joão", 1000.0,"CLT")
    val pedro = Funcionario("pedro", 8000.0,"PJ")
    val maria = Funcionario("maria", 4000.0,"CLT")

    println("---------------- criando lista mutavel--------\n\n")
    val funcionario = mutableListOf(joao,maria)
    funcionario.forEach{println("$it \n")}

    println("---------------- adcionando um elemento--------\n\n")
    funcionario.add(pedro)
    funcionario.forEach{println("$it \n")}

    println("---------------- removendo um elemento--------\n\n")
    funcionario.remove(joao) // = funcionario.removeAt(0)
    funcionario.forEach{println("$it \n")}

    println("---------------- criando lista com set of--------\n\n")

    val funcionario2 = mutableSetOf(joao)
    funcionario2.forEach{println("$it \n")}
    println("---------------- adcionando um elemento a setOf--------\n\n")
    funcionario2.add(pedro)
    funcionario2.add(maria)
    funcionario2.add(maria)// não repete objeto
    funcionario2.forEach{println("$it \n")}

    println("---------------- removendo um elemento de setOf--------\n\n")
    funcionario2.remove(joao) // = funcionario.removeAt(0)
    funcionario2.forEach{println("$it \n")}

}
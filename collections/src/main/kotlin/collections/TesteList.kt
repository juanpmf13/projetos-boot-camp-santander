package collections

fun main() {

    val joao = Funcionario("joão", 1000.0,"CLT")
    val pedro = Funcionario("pedro", 8000.0,"PJ")
    val maria = Funcionario("maria", 4000.0,"CLT")

    val funcionarios = listOf(joao, pedro, maria)

    funcionarios.forEach { println("$it \n") }
    println("---------------------------\n")
    println("funcionário maria : \n ${funcionarios.find { it.nome == "maria" }}")

    println("---------------------------\n")
    funcionarios.sortedBy { it.salario }.forEach { println("o'rdenado $it \n") }

    println("---------------------------\n")
    funcionarios.groupBy { it.tipoContratação }.forEach { println("$it \n") }
}





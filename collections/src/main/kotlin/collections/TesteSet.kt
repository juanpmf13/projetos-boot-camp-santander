package collections

fun main() {
    val joao = Funcionario("joão", 1000.0,"CLT")
    val pedro = Funcionario("pedro", 8000.0,"PJ")
    val maria = Funcionario("maria", 4000.0,"CLT")

    val funcionario1 = setOf( joao)
    val funcionario2 = setOf(pedro, maria)
    val funcionario3 = setOf( maria)



    println("------------------UNION--------------------\n\n")
    val resultadoUniao = funcionario1.union(funcionario2)
    resultadoUniao.forEach{println("$it \n")}


    println("------------------SUBTRACT--------------------\n\n")
    val resultadoSubtract = resultadoUniao.subtract(funcionario3)
    resultadoSubtract.forEach{println("$it \n")}

    println("------------------INTERSECT--------------------\n\n")
    val resultadoIntersect = resultadoUniao.intersect(funcionario3)
    resultadoIntersect.forEach{println("$it \n")}
}
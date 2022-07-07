package collections

fun main() {
    val joao = Funcionario("joão", 1000.0,"CLT")
    val pedro = Funcionario("pedro", 8000.0,"PJ")
    val maria = Funcionario("maria", 4000.0,"CLT")

    val repositori = Repositori<Funcionario>()
    repositori.create(joao.nome, joao)
    repositori.create(pedro.nome, pedro)
    repositori.create(maria.nome, maria)

    println(repositori.findBiId("joão"))
    println("----------------------------\n")
    repositori.findAll().forEach{ println("$it \n")}

    println("----------------------------\n")
    println(repositori.remove("maria"))

    println("-----------POS REMOÇÃO-----------------\n")

    repositori.findAll().forEach{ println("$it \n")}
}
package Introducao_OO

class Pessoa {
    var nome: String = "juan"
    var cpf: String = "123.456.789-10"
    inner class Endereco{
        var rua:String="são pedro"

    }

}

fun main(){
    val jether = Pessoa()

    println(jether.nome)
    println(jether.cpf)
    println(jether.Endereco().rua)

}
package Introducao_OO

class Pessoa {
    var nome: String = "juan"
    var cpf: String = "123.456.789-10"

    private set

    inner class Endereco{
        var rua:String="são pedro"

    }

    fun getcpf():String{
        return cpf
    }

}

fun main(){
    val jether = Pessoa()
    println(jether.nome)
    println(jether.getcpf())
    println(jether.Endereco().rua)

}
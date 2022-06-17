package Introducao_OO

class Pessoa {
    private var nome: String = "juan"
    private var cpf: String = "123.456.789-10"

    constructor()


    inner class Endereco{
        var rua:String="são pedro"

    }

    fun  getcpf():String{
        return cpf
    }

    fun pessoainf() = "nome : $nome cpf : $cpf"
}

fun main(){
    val jether = Pessoa()
    println(jether.pessoainf())
    println(jether.Endereco().rua)

}
package collections

class Pessoa(
) {
    var idade: Int = 0
    var nome: String =""
    var cpf : String= ""


    constructor(idade: Int,nome : String ,cpf: String) : this() {
        this.idade = idade
        this.nome =nome
        this.cpf = cpf

    }
    fun getnome():String {
        return nome
    }
}

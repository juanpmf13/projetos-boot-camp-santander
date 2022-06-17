package Introducao_OO

abstract class Pessoa(
     val nome:String,
     val cpf:String
    ) {


   fun  getcpf():String{
        return cpf
    }

    fun pessoainf() = "nome : $nome cpf : $cpf"
}


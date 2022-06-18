package Introducao_OO.Teste

import Introducao_OO.Cliente
import Introducao_OO.ClienteTipo

fun main(){
    val joao=Cliente(
        nome = "João Pereira",
        cpf="123.456.789-10",
        clienteTipo = ClienteTipo.PF,
        senha = "123456"
    )
    println(joao)
    TesteAutenticacao().autentica(joao)
}
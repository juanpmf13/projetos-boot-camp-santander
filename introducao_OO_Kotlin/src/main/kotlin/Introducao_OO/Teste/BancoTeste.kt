package Introducao_OO.Teste

import Introducao_OO.Banco

fun main(){
    val digiOneBank = Banco("DigiOne", 134)

    println(digiOneBank.nome)
    println(digiOneBank.numero)

    val banco2 = digiOneBank.copy("pedro", 13)

    println(banco2.info())
}
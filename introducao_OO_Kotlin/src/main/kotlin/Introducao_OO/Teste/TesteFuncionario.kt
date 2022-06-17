package Introducao_OO.Teste

import Introducao_OO.Funcionario
import java.math.BigDecimal

fun main(){
    val jether = Funcionario("juan","1234", BigDecimal.valueOf(2000.00))
    println(jether.nome)
    println(jether.cpf)
    println(jether.salario)
    println(jether)
}
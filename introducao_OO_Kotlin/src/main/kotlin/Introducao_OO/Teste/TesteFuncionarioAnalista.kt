package Introducao_OO.Teste

import Introducao_OO.Analista
import Introducao_OO.Funcionario
import java.math.BigDecimal

fun main(){
    val jether = Analista("juan","1234", 2000.0 )

    ImprimeRelatorioFuncionario.imprime(jether)
}

fun imprimeRelatorio(funcionario: Funcionario) = println(funcionario.toString())
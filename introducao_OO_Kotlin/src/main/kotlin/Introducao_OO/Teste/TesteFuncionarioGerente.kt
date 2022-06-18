package Introducao_OO.Teste

import Introducao_OO.Analista
import Introducao_OO.Funcionario
import Introducao_OO.Gerente
import java.math.BigDecimal

fun main(){
    val eduardo = Gerente("eduardo magalhães","1234", 7000.0 )

    ImprimeRelatorioFuncionario.imprime(eduardo)
}


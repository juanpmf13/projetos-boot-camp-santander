package Introducao_OO

import java.math.BigDecimal

abstract class Conta(
    val agencia:String,
    val numero:String,
    val saldo:BigDecimal
) {

    fun deposit(valor: BigDecimal){

    }

    fun saque(valor: BigDecimal){

    }
}
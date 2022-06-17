package Introducao_OO

import java.math.BigDecimal


abstract class Funcionario(
    nome:String,
    cpf:String,
    salario:BigDecimal
) : Pessoa(nome, cpf) {

    abstract fun calculoAuxilio();
}
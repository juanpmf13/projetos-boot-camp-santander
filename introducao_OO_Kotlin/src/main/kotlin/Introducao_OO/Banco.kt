package Introducao_OO

data class Banco(
    val nome: String,
    val numero: Int
) {
    fun info() = "Nome : $nome N : $numero"
}
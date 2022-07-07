package collections

class Funcionario (
    val nome: String,
    val salario: Double,
    val tipoContratação: String
)
{
    override fun toString(): String =
        """
            Nome: $nome
            Salario: $salario
            Tipo de Contratação : $tipoContratação
        """.trimIndent()


}
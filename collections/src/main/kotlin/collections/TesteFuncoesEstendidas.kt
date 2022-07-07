package collections

fun main() {
    val salarios = arrayOf(
        "2000".toBigDecimal(),
        "1500".toBigDecimal(),
        "2500".toBigDecimal()
    )
    println("somatoria ${salarios.somatoria()}")
    println("media ${salarios.media()}")
}
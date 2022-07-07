package collections

fun main() {
    val pair: Pair<String, Double> = Pair("joão",1500.0)
    val map1 = mapOf(pair)
    println(map1["joão"])

    map1.forEach { k ,v -> println("Chave: $k = Valor: v")}

    val map2 = mapOf(
        "pedro" to 2000.0,
        "monique" to 3000.0
        )

    map2.forEach { k ,v -> println("Chave: $k = Valor: v")}
}
package collections

fun main() {
    val values = IntArray(5)

    values[0]=1
    values[1]=3
    values[2]=45
    values[3]=5
    values[4]= 3;
    for(valor in values)
    println(valor)

    println("\n----------------\n")
    values.forEach {
        println(it)
    }

    println("\n----------------\n")

    for(index in values.indices){
        println(values[index])
    }

    values.sort()
    println("\n----------------\n")
    for(valor in values){
        println(valor)
    }
}
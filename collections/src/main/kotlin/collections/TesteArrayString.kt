package collections

fun main() {
    val nome = Array(3){""}
    nome[0]= "maria"
    nome[1]= "juan"
    nome[2]= "pablo"

    for(nomes in nome){
        println(nomes)
    }

    nome.sort()
    nome.forEach {
        println(it)
    }

    val nome2 = arrayOf("jojo","pedro","lucas")

    nome2.sort()
    println("---------------------------------")
    nome2.forEach {
        println(it)
    }
}
package collections


fun main() {
    val joao =  Pessoa(10,"João","12456789")
    val maria = Pessoa(20,"maria","555555555")
    val pessoa = MutableList(2){Pessoa()}
    pessoa.add(0,joao)
    pessoa.add(1,maria)
    println(pessoa.get(0).nome)
    println(pessoa.get(1).nome)
    var pessoa2 = MutableList(2){Pessoa()}
    pessoa2 = pessoa.filter { it.idade >= 10 } as MutableList<Pessoa>

    println(pessoa2.get(0).nome)
    println(pessoa2.get(1).nome)
}



package clase2

class MiClaseFuncion : (Int) -> Unit { // Podemos crear clases que implementan de un tipo funcion, en este caso sin parametros ni retorno.

    override fun invoke(x: Int) {
        println("Me invocaron con el valor: $x")
    }
}

fun main() {
    val function = MiClaseFuncion()
    function(4) // Imprime: "Me invocaron con el valor: 4"
    function.invoke(4)
    functionTypeEnProperties()
}

fun functionTypeEnProperties() {
    // Declaracion de variables de tipo funcion
    val saludo: () -> Unit

    val cuadrado: (Int) -> Int

    val producirImpresora: () -> ()->Unit

    // Inicializacion
    saludo = {
        println("Hello")
    }
    cuadrado = { x -> x * x }
    producirImpresora = { { println("Me estoy imprimiendo") } }

    // Uso
    saludo() // Imprime: Hello
    println(cuadrado(2)) // Imprime: 4
    producirImpresora()() // Imprime: Me estoy imprimiendo
}


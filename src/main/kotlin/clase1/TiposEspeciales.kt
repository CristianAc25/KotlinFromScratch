package clase1

import java.lang.Exception

class Book {
    // Ejemplo valor tipo Any
    fun imprimirValor(any: Any) {
        println(any.toString())
    }

    // Ejemplo valor tipo Unit
    fun saludar(nombre: String): Unit {
        println("Hola, $nombre!")
    }

    // Ejemplo 1 valor tipo Nothing
    fun loopForever(): Nothing {
        while (true) {
            println("Loop Infinito")
        }
    }

    // Ejemplo 2 valor tipo Nothing
    fun throwsExept(): Nothing = throw Exception("Esto es un crash!")

}

fun main() {
    val book = Book()

    // Ejemplo de uso valor Any
    val entero: Any = 10
    val cadena: Any = "Hola"

    book.imprimirValor(entero) // Imprime: 10
    book.imprimirValor(cadena) // Imprime: Hola

    // Ejemplo de uso valor Unit
    val resultado = book.saludar("Juan") // La función no devuelve nada, por lo que el tipo de 'resultado' es Unit
    println(resultado::class.simpleName) // Unit

    // Ejemplo de uso valor Nothing
    book.loopForever()
    val book2 = Book() // Este codigo es inalcanzable
}

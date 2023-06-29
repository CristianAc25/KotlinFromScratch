package clase1

fun main() {
    // Numbers
    var largo: Long = 10000000000
    var entero: Int = 10
    var corto: Short = 32000
    var byte: Byte = 127
    var doble: Double = 3.14159265359
    var flotante: Float = 3.14F

    // Char
    val caracter: Char = 'A'

    // Boolean
    val booleano: Boolean = true

    // Cadena
    val cadena: String = "Hola, mundo $entero"

    val rawString = """
        | Hola
        | Mundo!
    """.trimIndent()

    // Arreglos
    val arreglo = intArrayOf(1,2,3,4)

    val arregloObjNull = Array<Book?>(6) { null }
    val arregloObjInit = Array<Book?>(6) { Book() }

    val arregloInts = Array(5) { i -> println(i + 2) }

    val lista = mutableListOf(1,2,4)
    lista[2] = 5

    val hash = hashMapOf("One" to 1, "Dos" to 2)

    println(largo)
    println(entero)
    println(corto)
    println(byte)
    println(doble)
    println(flotante)
    println(caracter)
    println(booleano)
    println(cadena)
    println(arreglo)
}
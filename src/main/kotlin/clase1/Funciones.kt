package clase1

// Función declarada con cuerpo
fun sumar(a: Int, b: Int): Int {
    return a + b
}

// Función declarada como expresión body
fun restar(a: Int, b: Int): Int = a - b

// Función sin retorno
fun imprimirResta(a: Int, b: Int): Unit {
    println("Resultado de la resta: ${a - b}")
}

fun main() {
    // Uso de las funciones
    val resultadoSuma = sumar(3, 5)
    val resultadoResta = restar(8, 2)

    println("Resultado de la suma: $resultadoSuma") // Salida: Resultado de la suma: 8
    println("Resultado de la resta: $resultadoResta") // Salida: Resultado de la resta: 6
}